package loveletter.Servidor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

//import jugador.ManejoJugador;
import loveletter.Partida;
//import servidor.Servidor;

public class Servidor extends Thread {
	private int puerto= 12345;
	private static ServerSocket servidor;
	private boolean detener= false;
	//en esta linea crea una instancia de JUGADOR LOGUEADO Y LA INSTANCIA EN MENSAJE JUGADOR
	//private JugadorLogueado logger=null;
	private static Thread server;
	public static JTextArea log;
	private final static int ANCHO=700;
	private final static int ALTO=700;
	private final static int ALTO_LOG=700;
	private final static int ANCHO_LOG=ANCHO-700;
	private static int cantJugadoresConectados;
	//private Queue<ManejoJugador> colaEnEspera= new PriorityQueue <ManejoJugador>();
	
	@Override
	public void run() {
		try {
			//logger= new MensajesAJugador();
			log.append("Iniciando el servidor..."+ System.lineSeparator());
			servidor= new ServerSocket(puerto);
			log.append("Esperando conexiones..." + System.lineSeparator());
			servidor.setSoTimeout(10000);//NOSE SI PONE UN LIMITE DE ESPERA O QUE
			
			while(!detener) {
				try {
					Socket socketJugador= servidor.accept();
					log.append("El cliente: "+ socketJugador.getInetAddress().getHostAddress() + "se ha conectado" + System.lineSeparator());
					cantJugadoresConectados++;
					if(cantJugadoresConectados<4){//MIENTRAS NO INGRESEN 4 JUGADORES
						//ES COMO QUE AÑADIS UN JUGADOR AL HILO..(?
						//this.colaEnEspera.add(new ManejoJugador(socketJugador, logger));
					}else {
						//CUANDO YA SE CONECTAN TODOS MIS JUGADORES:
						//ARRANCO EL TABLERO Y METO A LOS JUGADORES
						//Partida.comenzarJuego//ALGO ASI
						//new Thread(new ManejoJugador(socketJugador, logger)).start();//ACA ARRANCA EL HILO DEL PRIMER JUGADOR
						/*while(!this.colaEnEspera.isEmpty()) {
							new Thread(this.colaEnEspera.poll()).start();*///MIENTRAS NO SE VACIE
						//LA LISTA DE JUGADORES CONECTADOS LOS HAGO ARRANCAR(EN MI CASO SON 4);
					}
					
				} catch (SocketTimeoutException ex) {
					
				}
			}
		} catch (IOException e) {
		}
	}
	
	public synchronized void finalizar() {
		this.detener=true;
	}
	
	public static void main(String[] args) {
		cargarInterfaz();
	}
	
	public static void cargarInterfaz() {
		JFrame ventana= new JFrame("Servidor: ");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(ANCHO, ALTO);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		ventana.setBackground(Color.BLACK);
		JLabel titulo = new JLabel("SERVIDOR: ...");
		titulo.setFont(new Font("Courier New", Font.BOLD,16));
		titulo.setBounds(10, 0, 200, 30);
		ventana.add(titulo);
		
		log= new JTextArea();
		log.setEditable(false);
		log.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		JScrollPane scroll = new JScrollPane(log, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(10, 40, ANCHO_LOG, ALTO_LOG);
		ventana.add(scroll);
		
		final JButton botonIniciar = new JButton();
		final JButton botonDetener = new JButton();
		botonIniciar.setText("Iniciar");
		botonIniciar.setBounds(220, ALTO - 70, 100, 30);
		botonIniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				server = new Thread(new Servidor());
				server.start();
				botonIniciar.setEnabled(false);
				botonDetener.setEnabled(true);
			}
		});
		
		ventana.add(botonIniciar);

		botonDetener.setText("Detener");
		botonDetener.setBounds(360, ALTO - 70, 100, 30);
		botonDetener.addActionListener(new ActionListener() {
			@Override
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					server.stop();
					servidor.close();
					log.append("El servidor se ha detenido." + System.lineSeparator());
				} catch (IOException e1) {
					log.append("Fallo al intentar detener el servidor." + System.lineSeparator());
				}
				botonDetener.setEnabled(false);
				botonIniciar.setEnabled(true);
			}
		});
		botonDetener.setEnabled(false);
		ventana.add(botonDetener);

		ventana.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			@SuppressWarnings("deprecation")
			public void windowClosing(WindowEvent evt) {
				if (servidor != null) {
					try {
						server.stop();
						servidor.close();
						log.append("El servidor se ha detenido." + System.lineSeparator());
					} catch (IOException e) {
						log.append("Fallo al intentar detener el servidor." + System.lineSeparator());
						System.exit(1);
					}
				}
				System.exit(0);
			}
		});
		ventana.setVisible(true);
	}
	
	public static JTextArea getLog() {
		return log;
	}
	
	public static void setLog(final JTextArea log) {
		Servidor.log = log;
	}
	
	public static void quitarJugador() {
 		cantJugadoresConectados--;
 	}	
	
}



