package loveletter.Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loveletter.Jugador;

public class VentanaGanadorRonda extends JFrame {

	private JPanel panel;
	private JLabel etiqueta;
	private JButton botonContinuar;
	private JLabel winner;
	private boolean confirmacion=true;

	public VentanaGanadorRonda(Jugador Ganador) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setTitle("Love Letter");
		setDefaultCloseOperation(0); 
		//setBounds(100, 100, 398, 68);
		
		setSize(380,221);
		setLocationRelativeTo(null);
		//setVisible(true);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		setContentPane(panel);
		panel.setLayout(null);

		
		etiqueta = new JLabel();
		etiqueta.setBounds(41, 11, 291, 49);
		etiqueta.setFont(new Font("Consolas", Font.BOLD, 30));
		etiqueta.setText("El ganador de la ronda es");
		panel.add(etiqueta);
		
		botonContinuar = new JButton("Continuar...");
		botonContinuar.setBounds(119, 121, 118, 23);
		botonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirmacion=false;
				//dispose();
			}
		});
		panel.add(botonContinuar);
		
		winner = new JLabel(Ganador.getNombre());
		winner.setFont(new Font("Consolas", Font.BOLD, 40));
		winner.setBounds(155, 71, 46, 23);
		panel.add(winner);
				
		}
	
	public boolean getConfirmacion() {
		return confirmacion;		
	}
	
}
