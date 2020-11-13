package loveletter.Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import loveletter.Carta;
import loveletter.Jugador;
import loveletter.EstadosJugador.EnEspera;
import loveletter.EstadosJugador.EnJuego;

//public class Tablero extends JFrame implements Runnable  {
public class ComponenteGrafico extends JFrame {

	private static final long serialVersionUID = 1L;

	// OJO: Los valores de SKIP son un resultado de una división entera!
	private final int SECOND = 1000;
	private final int FRAMES_PER_SECOND = 60;
	private final int SKIP_FRAMES = SECOND / FRAMES_PER_SECOND;
	private final int TICKS_PER_SECOND = 1000;
	private final int SKIP_TICKS = SECOND / TICKS_PER_SECOND;

	private final int RESOL_HEIGHT = 1080;
	private final int RESOL_WIDTH = 1920;

	private boolean is_running = true;

	private DrawPanel drawPanel;
	private BufferedImage background;
	private BufferedImage backgroundTurno;
	// Estas serian las cartas CLIQUEABLES, es decir las de la mano.
	private ArrayList<ClickeableCarta> cartasEnMano = new ArrayList<ClickeableCarta>();

	// Estas son las cartas que estan en el tablero, solamente se van agregando al
	// final en secuencia.
	private ArrayList<LayoutCarta> cartasEnTablero = new ArrayList<LayoutCarta>();
	private ArrayList<JugadorGraphics> jugadoresEnTablero = new ArrayList<JugadorGraphics>();

	private int loops = 0;
	private int fps = 0;

	private int screenWidth;
	private int screenHeight;

	private int contadorTemporal = 0;

	private boolean clickCartaMano = false;
	private double clicksEnPantalla = 0;
	private boolean mostrarPantallaNegra = false;
	private boolean pantallaFinDeRonda = false;
	private Carta cartaCliqueada = null;

	public ComponenteGrafico() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		this.screenWidth = pantalla.width;
		this.screenHeight = pantalla.height;

		// Carta izquierda 1, carta derecha 2
		cartasEnMano.add(new ClickeableCarta(1));
		cartasEnMano.add(new ClickeableCarta(2));
	}

	private class DrawPanel extends JPanel {
		private static final long serialVersionUID = 91574813372177663L;

		public DrawPanel() {
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent me) {
					super.mouseClicked(me);
					Point point = me.getPoint();
					Dimension currentDimension = getContentPane().getSize();
					System.out.print("Click en: [" + (point.x * WIDTH / currentDimension.getWidth()) + ", ");
					System.out.println(point.y * HEIGHT / currentDimension.getHeight() + "]");
					clicksEnPantalla++;
					for (ClickeableCarta carta : cartasEnMano) {
						// Hay que tener en cuenta tambien que la carta ESTE CONTENIDA dentro del
						// ClickeableCarta para realmente tomar el click
						if (carta.fuiCliqueada(point.x * WIDTH / currentDimension.getWidth(),
								point.y * HEIGHT / currentDimension.getHeight())) {
							cartaCliqueada = carta.getCartaContenida();
							clickCartaMano = true;
							break;
						}
					}
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;

			Dimension currentDimension = getContentPane().getSize();
			g2.scale(currentDimension.getWidth() / RESOL_WIDTH, currentDimension.getHeight() / RESOL_HEIGHT);
			g2.drawImage(mostrarPantallaNegra ? backgroundTurno : background, null, 0, 0);

//			g2.setColor(Color.WHITE);
//			g2.setFont(new Font("Dialog", Font.BOLD, 24));
//			g2.drawString("Time: " + String.format("%6s", loops * SKIP_TICKS) + "ms", 20, 25);
//			g2.drawString("FPS: " + fps + "", 240, 25);

			if (!mostrarPantallaNegra) {

				int cont=1;
				for (int i = 0; i < jugadoresEnTablero.size(); i++) {
					String nombreJugador = jugadoresEnTablero.get(i).getNombre();
					if (jugadoresEnTablero.get(i).getEstado().equals(new EnJuego())) { /// faltara un equals?
						g2.setColor(Color.BLACK);
						g2.setFont(new Font("Arial", Font.BOLD, 60));
						g2.drawString(nombreJugador, 430, 880);
					} else {
						g2.setColor(Color.BLACK);
						g2.setFont(new Font("Arial", Font.BOLD, 30));
						g2.drawString(nombreJugador, (cont==1)?360:((cont==2)?920:1485), 80); // deberia setear en el mismo lugar donde estan
						cont++;
						// los cuadrados
					}
					
				}

				for (int i = 0; i < cartasEnTablero.size(); i++) {
					LayoutCarta carta = cartasEnTablero.get(i);
					g2.drawImage(carta.getCartaContenida().getBufferedImage(), carta.getCoordX(), carta.getCoordY(),
							null);
				}

				for (int i = 0; i < cartasEnMano.size(); i++) {
					ClickeableCarta carta = cartasEnMano.get(i);
					if (carta.getCartaContenida() != null) {
						g2.drawImage(carta.getCartaContenida().getBufferedImage(),
								i == 0 ? carta.getCoordX_head_izq() : carta.getCoordX_head_der(),
								carta.getCoordY_head(), carta.getScaleWidth(), carta.getScaleHeight(), null);
					}
				}
			}

		}

		// Me dice el tama�o que debo tener al redimensionar.
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(WIDTH, HEIGHT);
		}
	}

	public void init() {

		try {
			background = ImageIO.read(new File("assets/other/background_v3.jpg"));
			backgroundTurno = ImageIO.read(new File("assets/other/siguiente_turno2.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// Se crea un drawPanel y se dibuja inicialmente.
		drawPanel = new DrawPanel();
		add(drawPanel);
		// Ajustar el JFrame al JPanel que incluye, xq el JFrame no tiene tama�o.
		pack();
		setSize(this.screenWidth, this.screenHeight);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setFocusable(true);
		requestFocusInWindow();
	}

//	@Override
	// La idea de este metodo es realizar una transicion o algo.
	// Va updateando datos y aumentando fps y refrescando pantalla.
	// Esto lo hace hasta que el flag de haciendoAccion termine.
	public boolean realizarTransicion() {
		// Quiza lo mejor seria mandarle por parametor algun codigo o TIPO de
		// transicion, para que el metodo sepa que elemento tiene que mover. Esto
		// podriamos mandarselo al metodo updateData
		long next_game_tick = System.currentTimeMillis();
		long next_game_frame = System.currentTimeMillis();
		long next_frame_calc = System.currentTimeMillis();
		int frames = 0;
		boolean haciendoAccion = false;

		System.out.println("Quiere hacer algo");
		do {
			System.out.println("Haciendo algo!");
			// Hacer transicion de elementos en pantalla.
			if (System.currentTimeMillis() > next_game_tick) {
				loops++;
				next_game_tick += SKIP_TICKS;

				// Este metodo update va incrementando valores, y devolvera falso cuando ya no
				// haya nada mas que actualizar
				// Por ende, termino la transicion y el flag deberia sacarlo del bucle.
				haciendoAccion = updateComponentData();
			}
			if (System.currentTimeMillis() > next_game_frame) {
				frames++;
				next_game_frame += SKIP_FRAMES;
				// Repaint para refrescar y mostrar en pantalla.
				refreshScreen();
			}
			if (System.currentTimeMillis() > next_frame_calc) {
				fps = frames;
				next_frame_calc += SECOND;
				frames = 0;
			}
		} while (haciendoAccion);

		return !haciendoAccion;
	}

	public boolean updateComponentData() {
		// Este update deberia VARIAR dependiendo de QUE quiero mover o actualizar.
		// Una sola cosa que es esperar a llegar a 20000;
		System.out.println("Want to updateComponentData");
		this.contadorTemporal++;

		return contadorTemporal == 100;

	}

	public void refreshScreen() {
		drawPanel.repaint();
	}

	public Carta retornarCartaSeleccionada() {
		while (!this.clickCartaMano) {
			// System.out.println("Estoy esperando el click del usuario.");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// System.out.println("Cliqueo carta!");
		return this.cartaCliqueada;
	}

	public void refrescarSeleccionDeCarta() {
		this.clickCartaMano = false;
		this.cartaCliqueada = null;
	}

	public void setCartaEnTablero(Carta carta) {
		LayoutCarta cartaNueva;
		int indexUltimaCarta;
		if (this.cartasEnTablero.size() == 0) {
			cartaNueva = new LayoutCarta();
		} else {
			indexUltimaCarta = this.cartasEnTablero.size() - 1;
			LayoutCarta ultima = this.cartasEnTablero.get(indexUltimaCarta);
			cartaNueva = new LayoutCarta(ultima.getCoordX() + 100);
		}
		cartaNueva.setCartaContenida(carta);
		this.cartasEnTablero.add(cartaNueva);
		this.drawPanel.repaint();
	}

	public void setCartasEnMano(Carta carta) {
		if (this.cartasEnMano.get(0).getCartaContenida() == null) {
			this.cartasEnMano.get(0).setCartaContenida(carta);
		} else {
			this.cartasEnMano.get(1).setCartaContenida(carta);
		}
		this.drawPanel.repaint();
	}

	public void quitarCartaDeMano(Carta carta) {

		if (this.cartasEnMano.get(0).getCartaContenida().equals(carta)) {
			this.cartasEnMano.get(0).setCartaContenida(null);
		} else {
			this.cartasEnMano.get(1).setCartaContenida(null);
		}
	}

	public void mostraPantallaCambioTurno() {
		double clickPantalla = this.clicksEnPantalla;
		this.mostrarPantallaNegra = true;
		while (clickPantalla == this.clicksEnPantalla) {
			// Hizo algun click?
			// System.out.println("Estoy esperando el click del usuario.");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.mostrarPantallaNegra = false;
		this.pantallaFinDeRonda = false;

	}

	public void mostrarPantallaFinRonda() {

	}

	public void limpiarMano() {

		this.cartasEnMano.get(0).setCartaContenida(null);
		this.cartasEnMano.get(1).setCartaContenida(null);

	}

	public void remplazarManoEnPantalla(Carta carta) {
		this.cartasEnMano.get(0).setCartaContenida(carta);
	}

	public void ponerJugadoresEnPantalla(ArrayList<Jugador> jugadores) {
		this.jugadoresEnTablero  = new ArrayList<JugadorGraphics>();
		JugadorGraphics jugador1;
		for (int i = 0; i < jugadores.size(); i++) {
			jugador1 = new JugadorGraphics(jugadores.get(i).getNombre(), jugadores.get(i).getEstadoActual());
			this.jugadoresEnTablero.add(jugador1);
		}

		/// no me gusta crear tantos objetos, capaz se puede mejorar
		// estoy agregando los jugadores actuales a mi atributo de jugadoresEn Tablero

	}

	public void limpiarContenido() {
		limpiarMano();
		this.cartasEnTablero = new ArrayList<LayoutCarta>();

	}

	public void cerrarPantalla() {
		System.out.println("Termino todo...");
//		try {
//			Thread.sleep(100000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
