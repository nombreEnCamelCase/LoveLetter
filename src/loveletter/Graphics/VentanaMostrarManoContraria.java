package loveletter.Graphics;

import java.awt.Color;
import java.awt.Font;

import java.awt.Image;




import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import loveletter.Jugador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class VentanaMostrarManoContraria extends JFrame {

	
	private JPanel panel;
	private JLabel etiqueta;
	private boolean confirmacion=true;
	private JButton botonContinuar;
	private JLabel punt2;

	
	public VentanaMostrarManoContraria(Jugador objetivo) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setTitle("Love Letter");
		setDefaultCloseOperation(0); 
		
		setSize(422,472);
		setLocationRelativeTo(null);		
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		setContentPane(panel);
		panel.setLayout(null);
		
		etiqueta = new JLabel();
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta.setBounds(10, 11, 396, 49);
		etiqueta.setFont(new Font("Consolas", Font.PLAIN, 20));
		etiqueta.setText("Mano de "+objetivo.getNombre());
		panel.add(etiqueta);
		
		botonContinuar = new JButton("Continuar...");
		botonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmacion=false;
			}
		});
		botonContinuar.setBounds(147, 397, 118, 23);
		
		panel.add(botonContinuar);
		
		punt2 = new JLabel();
		punt2.setHorizontalAlignment(SwingConstants.CENTER);
		punt2.setBounds(95, 53, 216, 301);
		
		ImageIcon fot = new ImageIcon(objetivo.getMano().getCartaActual().getImgUri());
		ImageIcon icono = new ImageIcon(fot.getImage().getScaledInstance(punt2.getWidth(), punt2.getHeight(), Image.SCALE_DEFAULT));
		punt2.setIcon(icono);
		panel.add(punt2);
		
	}
	
	public boolean getConfirmacion() {
		return confirmacion;		
	}
}
