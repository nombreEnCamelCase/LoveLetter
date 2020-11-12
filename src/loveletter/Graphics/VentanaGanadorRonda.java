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
	private boolean confirmacion=false;

	public VentanaGanadorRonda(Jugador Ganador) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Love Letter");
		//setBounds(100, 100, 398, 68);
		
		setSize(380,221);
		setLocationRelativeTo(null);
		
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		setContentPane(panel);
		panel.setLayout(null);
		panel.setLayout(null);
		
		etiqueta = new JLabel();
		etiqueta.setBounds(94, 11, 181, 49);
		etiqueta.setFont(new Font("Consolas", Font.PLAIN, 20));
		etiqueta.setText("El ganador es");
		panel.add(etiqueta);
		
		botonContinuar = new JButton("Continuar...");
		botonContinuar.setBounds(119, 121, 118, 23);
		botonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirmacion=true;
				//dispose();
			}
		});
		panel.add(botonContinuar);
		
		winner = new JLabel(Ganador.getNombre());
		winner.setBounds(155, 71, 46, 23);
		panel.add(winner);
				
		}
	
	public boolean getComfirmacion() {
		return confirmacion;		
	}
	
}
