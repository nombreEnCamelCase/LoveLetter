package loveletter.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import loveletter.Jugador;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaCartas extends JFrame {

	private static final long serialVersionUID = 1779064557725749287L;
	private JPanel panel;
	private JLabel etiqueta, etiqueta1, cantidad;
	private JButton boton;
	private int desplazmientoY = 50;
	private String cartaSeleccionada;
	private boolean confirmacion = false;
	private static String []cartas = {	"Sacerdote","2",
										"Baron","2",
										"Mucama","2",
										"Principe","2",
										"Rey","1",
										"Condesa","1",
										"Princesa","1"};
	public VentanaCartas() {
		setResizable(false);
		setTitle("Lista De Cartas");
		setDefaultCloseOperation(0); 
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setLayout(null);

		etiqueta = new JLabel();
		etiqueta.setFont(new Font("Consolas", Font.PLAIN, 20));
		etiqueta.setText("Seleccione carta");
		etiqueta.setBounds(110, 11, 230, 28);

		panel.add(etiqueta);
		getContentPane().add(panel);
		
		for (int i = 0; i < cartas.length; i++) {
			boton = new JButton(cartas[i]);
			boton.setBounds(151, desplazmientoY + 15* i, 100, 23);
			cantidad = new JLabel(cartas[++i]);
			cantidad.setBounds(255, desplazmientoY + 15 * ((i)-1) , 100, 23);
			boton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					setCartaSeleccionada(arg0.getActionCommand());
					dispose();
				}

			});
			panel.add(cantidad);
			panel.add(boton);
		}

		setSize(400, 400);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public VentanaCartas(Jugador accionador, Jugador objetivo, String resultado, String cartaObjetivo) {
		setResizable(false);
		setTitle("¡Resultado de efecto Guardia!");
		setDefaultCloseOperation(0); 

		panel = new JPanel();
		panel.setLayout(null);

		getContentPane().add(panel);
		
		etiqueta = new JLabel("El jugador " + accionador.getNombre() + " selecciono la carta " + cartaObjetivo + " y");
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta.setFont(new Font("Consolas", Font.PLAIN, 14));
		etiqueta.setBounds(10, 31, 416, 39);
		panel.add(etiqueta);
		
		boton = new JButton("Continuar");
		boton.setBounds(180, 165, 89, 23);
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirmacion=true;
				dispose();
			}
		});
		panel.add(boton);
		
		etiqueta1 = new JLabel("fue " + resultado);
		etiqueta1.setFont(new Font("Consolas", Font.PLAIN, 14));
		etiqueta1.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta1.setBounds(10, 92, 416, 39);
		panel.add(etiqueta1);
	
		
		
		setSize(450, 250);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	public boolean getConfirmacion() {
		return confirmacion;
	}
	
	public void setCartaSeleccionada( String Seleccionada ) {
		cartaSeleccionada = Seleccionada;
	}
	
	public String getCartaSeleccionada() {
		return cartaSeleccionada;
	}
}
