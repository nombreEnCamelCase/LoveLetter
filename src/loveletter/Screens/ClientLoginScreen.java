package loveletter.Screens;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import loveletter.Client.PlayerClient;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class ClientLoginScreen extends JDialog {

	/**
	 * La clase ClientLoginScreen ejecuta el menu para registrarse en la bd.
	 */
	private final JPanel contentPanel = new JPanel();
	private JTextField textUsuario;
	private JTextField text_IP_Servidor;
	private JTextField text_PORT;
	// private JPasswordField passContrasenia;

	public ClientLoginScreen() {
		setResizable(false);
		setBackground(Color.WHITE);
		setTitle("Ingresar a sala de juego");
		setBounds(530, 430, 300, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.YELLOW);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		textUsuario = new JTextField();
		textUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		textUsuario.setToolTipText("");
		textUsuario.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {

			}
		});
		textUsuario.setBounds(140, 40, 120, 20);
		contentPanel.add(textUsuario);
		textUsuario.setColumns(10);
		{
			JLabel lblUsuario = new JLabel("Usuario");
			lblUsuario.setBounds(30, 40, 90, 20);
			contentPanel.add(lblUsuario);
		}
		{
			JLabel lblServer = new JLabel("IP Server");
			lblServer.setBounds(30, 70, 90, 20);
			contentPanel.add(lblServer);
		}
		{
			JLabel lblPuerto = new JLabel("Puerto");
			lblPuerto.setBounds(30, 100, 90, 20);
			contentPanel.add(lblPuerto);
		}

		text_IP_Servidor = new JTextField();
		text_IP_Servidor.setText("localhost");
		text_IP_Servidor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		text_IP_Servidor.setToolTipText("");
		text_IP_Servidor.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {

			}
		});
		text_IP_Servidor.setBounds(140, 70, 120, 20);
		contentPanel.add(text_IP_Servidor);
		text_IP_Servidor.setColumns(10);

		text_PORT = new JTextField();
		text_PORT.setText("20000");
		text_PORT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		text_PORT.setToolTipText("");
		text_PORT.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {

			}
		});
		text_PORT.setBounds(140, 100, 120, 20);
		contentPanel.add(text_PORT);
		text_PORT.setColumns(10);
		{

			{
				JButton okButton = new JButton("Ingresar");
				okButton.setBounds(75, 160, 150, 50);
				contentPanel.add(okButton);
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						PlayerClient client = new PlayerClient(text_IP_Servidor.getText(),
								Integer.parseInt(text_PORT.getText()),textUsuario.getText());
						client.execute();
						dispose();

					}
				});
			}

		}
	}

}
