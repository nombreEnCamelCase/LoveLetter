package loveletter.Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class Login extends JDialog {

	/**
	 * La clase MenuLogin ejecuta el menu para registrarse en la bd.
	 */
	private final JPanel contentPanel = new JPanel();
	private JTextField textUsuario;
	private JPasswordField passContrasenia;

	public Login() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();

		setSize(pantalla.width,pantalla.height);
		setBackground(Color.WHITE);
		setTitle("Inicio de Sesi\u00F3n");
		setBounds(530, 430, 300, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GREEN);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		textUsuario = new JTextField();
		textUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textUsuario.setText("");
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
			JLabel lblContrasenia = new JLabel("Contrase\u00F1a");
			lblContrasenia.setBounds(30, 100, 90, 20);
			contentPanel.add(lblContrasenia);
		}

		passContrasenia = new JPasswordField();
		passContrasenia.setBounds(140, 100, 120, 20);
		contentPanel.add(passContrasenia);
		{

			{
				JButton okButton = new JButton("Jugar");
				okButton.setBounds(30, 160, 100, 50);
				contentPanel.add(okButton);
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
//						MenuSala menuSala;
//						menuSala = new MenuSala(textUsuario.getText());
						System.out.println("Se quiere conectar");
							//new Cliente(textUsuario.getText());

					}
				});
			}

			{
				JButton cancelButton = new JButton("Volver");
				cancelButton.setBounds(160, 160, 100, 50);
				contentPanel.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
		}
	}
}
