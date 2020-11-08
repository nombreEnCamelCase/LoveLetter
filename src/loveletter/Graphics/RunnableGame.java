package loveletter.Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import demo_ball_real_time_with_gravity.Ball;
//import demo_ball_real_time_with_gravity.Player;

public class RunnableGame  extends JFrame implements Runnable  {
	
	private static final long serialVersionUID = 1L;

	// OJO: Los valores de SKIP son un resultado de una divisiÃ³n entera!
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

	private int loops = 0;
	private int fps = 0;
	
	private int screenWidth;
	private int screenHeight;
	
	public RunnableGame() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		this.screenWidth = pantalla.width;
		this.screenHeight = pantalla.height;
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
				}
			});
		}

		// 
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;

			Dimension currentDimension = getContentPane().getSize();
			g2.scale(currentDimension.getWidth() / RESOL_WIDTH, currentDimension.getHeight() / RESOL_HEIGHT);
			g2.drawImage(background, null,0, 0);

			g2.setColor(Color.WHITE);
			g2.setFont(new Font("Dialog", Font.BOLD, 24));
			g2.drawString("Time: " + String.format("%6s", loops * SKIP_TICKS) + "ms", 20, 25);
			g2.drawString("FPS: " + fps + "", 240, 25);

			 try {
				 // Jugador 1 - IZQ - TABLERO
				 g2.drawImage(ImageIO.read(new File("assets/cards/baron.png")),60,220,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/rey.png")),60+50,220,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),60+50*2,220,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),60+50*3,220,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),60+50*4,220,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),60+50*5,220,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),60+50*6,220,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),60+50*7,220,null);
			 }catch(Exception ex) {
				 
			 }
			 
			 try {
				 // Jugador 2 - CENTRO - TABLERO
				 g2.drawImage(ImageIO.read(new File("assets/cards/baron.png")),650,220,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/rey.png")),650+50,220,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),650+50*2,220,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),650+50*3,220,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),650+50*4,220,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),650+50*5,220,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),650+50*6,220,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),650+50*7,220,null);
			 }catch(Exception ex) {
				 
			 }
			 
			 try {
				 // Jugador 3 - DER - TABLERO
				 g2.drawImage(ImageIO.read(new File("assets/cards/baron.png")),1240,190,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/rey.png")),1240+50,200,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),1240+50*2,210,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),1240+50*3,180,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),1240+50*4,190,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),1240+50*5,200,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),1240+50*6,190,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),1240+50*7,200,null);
			 }catch(Exception ex) {
				 
			 }
			 
			 try {
				 // Jugador JUGANDO - TABLERO
				 g2.drawImage(ImageIO.read(new File("assets/cards/baron.png")),250,600,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/rey.png")),250+50,600,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),250+50*2,600,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),250+50*3,600,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),250+50*4,600,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),250+50*5,600,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),250+50*6,600,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/condesa.png")),250+50*7,600,null);
			 }catch(Exception ex) {
				 
			 }
			 
			 try {
				 // Jugador JUGANDO - MANO
				 
				 // La wea rotada.
//				 BufferedImage hand1 = ImageIO.read(new File("assets/cards/baron.png"));
//				 AffineTransform t = new AffineTransform();
//				 t.translate(1030,700);
//				 t.rotate(Math.toRadians(-15));
//				 g2.drawImage(hand1,t,null);
				 
				 //Anteriores sin escala
//				 g2.drawImage(ImageIO.read(new File("assets/cards/baron.png")),1100,700,405,480,null);
//				 g2.drawImage(ImageIO.read(new File("assets/cards/rey.png")),1400,700,405,480,null);
				 
				 g2.drawImage(ImageIO.read(new File("assets/cards/baron.png")),1000,550,335,460,null);
				 g2.drawImage(ImageIO.read(new File("assets/cards/rey.png")),1350,550,335,460,null);
			 }catch(Exception ex) {
				 
			 }
		}

		// Me dice el tamaño que debo tener al redimensionar.
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(WIDTH, HEIGHT);
		}
	}
	
	public void init() {
		drawPanel = new DrawPanel();
		add(drawPanel);
		// Ajustar el JFrame al JPanel que incluye, xq el JFrame no tiene tamaño.
		pack();
		setSize(this.screenWidth,this.screenHeight);
		
		try {
			background = ImageIO.read(new File("assets/other/background-simp.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		

		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setFocusable(true);

		requestFocusInWindow();
	}
	
	@Override
	public void run() {
		// System.nanoTime no es seguro entre distintos Threads
		// En caso de querer utilizarse igual para aumentar la precision en
		// valores altos de fps o de ticks se debe aumentar tambiÃ©n el valor
		// de las constantes, para que esten en ns y no en ms

		long next_game_tick = System.currentTimeMillis();
		long next_game_frame = System.currentTimeMillis();
		long next_frame_calc = System.currentTimeMillis();
		int frames = 0;

		while (is_running) {
			if (System.currentTimeMillis() > next_game_tick) {
				loops++;
				next_game_tick += SKIP_TICKS;
				update();
			}
			if (System.currentTimeMillis() > next_game_frame) {
				frames++;
				next_game_frame += SKIP_FRAMES;
				display();
			}
			if (System.currentTimeMillis() > next_frame_calc) {
				fps = frames;
				next_frame_calc += SECOND;
				frames = 0;
			}
		}
	}
	
	public void update() {
//		System.out.println("Want to update");
//		player.move(1.0 / TICKS_PER_SECOND);
//		ball.move(1.0 / TICKS_PER_SECOND);
	}

	public void display() {
//		System.out.println("Muestra");
		drawPanel.repaint();
	}
	

	
	
	public static void main(String[] args) throws Exception {
		RunnableGame game = new RunnableGame();
		game.init();
		game.run();
	}
}
