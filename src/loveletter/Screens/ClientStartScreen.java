package loveletter.Screens;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loveletter.Utilities.Sonido;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class ClientStartScreen extends JFrame {
	/**
	 * La clase MenuOInicio ejecuta el menu para iniciar el juego.
	 */
	private JPanel contentPane;
	private final int RESOL_HEIGHT = 1080;
	private final int RESOL_WIDTH = 1920;
	private int connectionPort;
	public void cargarInterfaz(int port) throws ClassNotFoundException, LineUnavailableException, IOException {
		this.connectionPort = port;
		EventQueue.invokeLater(new Runnable() {
		
			public void run() {
				try {
					ClientStartScreen frame = new ClientStartScreen(connectionPort);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setSize(800, 600);
					frame.setLocation(dim.width / 2 - frame.getWidth() / 2, dim.height / 2 - frame.getHeight() / 2);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ClientStartScreen(int port)
			throws ClassNotFoundException, LineUnavailableException, IOException, UnsupportedAudioFileException {
		this.connectionPort= port;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		Sonido musica = new Sonido("utilidades/simpsons.wav");
//		musica.comenzar();
		
		JButton btnJugar = new JButton("JUGAR");
		btnJugar.setBackground(Color.YELLOW);
		btnJugar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ClientLoginScreen menuJugar = new ClientLoginScreen(connectionPort);
				menuJugar.setVisible(true);
				dispose();
			}
		});
		btnJugar.setBounds(300, 400, 200, 50);
		contentPane.add(btnJugar);

	}

	@Override
	public void paint(Graphics gra) {
		super.paint(gra);
		try {
			BufferedImage fondo = ImageIO.read(new File("assets/other/wallpaper.jpg"));
			Graphics2D g2 = (Graphics2D) gra;
			Dimension currentDimension = getContentPane().getSize();
			g2.scale(currentDimension.getWidth() / RESOL_WIDTH, currentDimension.getHeight() / RESOL_HEIGHT);
			g2.drawImage(fondo, null, 0, 0);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
