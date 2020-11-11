package loveletter.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import loveletter.Jugador;
import loveletter.Partida;

import java.awt.Font;
import javax.swing.JRadioButton;

public class VentanaAlerta extends JFrame {

	private static final long serialVersionUID = 1779064557725749287L;
	private JPanel panel;
	private JLabel etiqueta;
	private JButton boton;
	private int desplazmientoY = 50;
	private String nombreVictima;
	private ArrayList<Jugador> jugadoresVictima = new ArrayList<Jugador>();
	
	public VentanaAlerta(ArrayList<Jugador> jugadoresVictima) {
//		
		this.jugadoresVictima = jugadoresVictima;

		setResizable(false);
		setTitle("Love Letter");

		panel = new JPanel();
		panel.setLayout(null);

		etiqueta = new JLabel();
		etiqueta.setFont(new Font("Consolas", Font.PLAIN, 20));
		etiqueta.setText("Lista De Jugadores");
		etiqueta.setBounds(101, 11, 230, 28);

		panel.add(etiqueta);
		getContentPane().add(panel);

		for (int i = 0; i < jugadoresVictima.size(); i++) {
			boton = new JButton(jugadoresVictima.get(i).getNombre());
			boton.setBounds(151, desplazmientoY + 30 * i, 100, 23);
			
			boton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					nombreVictima = arg0.getActionCommand();
				}

			});
			panel.add(boton);
		}

		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public Jugador getJugadorVictima() {
		for (int i = 0; i < jugadoresVictima.size(); i++) {
			if(jugadoresVictima.get(i).getNombre().equals(nombreVictima)) {
				return jugadoresVictima.get(i);
			}
		}
		return null;
	}
}
