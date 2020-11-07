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

	private int loops = 0;
	private int fps = 0;
	
	private int screenWidth;
	private int screenHeight;
	
	public RunnableGame() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		this.screenWidth = pantalla.width;
		this.screenHeight = pantalla.height;
	}
	
	public void init() {
		try {
			background = ImageIO.read(new File("assets/other/background.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();

		}

		drawPanel = new DrawPanel();
		add(drawPanel);

		pack();
		setSize(this.screenWidth,this.screenHeight);
		
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
		// valores altos de fps o de ticks se debe aumentar también el valor
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

		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(WIDTH, HEIGHT);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		RunnableGame game = new RunnableGame();
		game.init();
		game.run();
	}
}
