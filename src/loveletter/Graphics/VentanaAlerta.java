package loveletter.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import loveletter.Carta;
import loveletter.Jugador;
import loveletter.Partida;
import loveletter.EstadosJugador.Estado;
import loveletter.EstadosJugador.Inmune;

import java.awt.Font;
import javax.swing.JRadioButton;

public class VentanaAlerta extends JFrame {

	private static final long serialVersionUID = 1779064557725749287L;
	private JPanel panel;
	private JLabel etiqueta;
	private JButton boton;
	private int desplazmientoY = 50;
	private String nombreSeleccionado;
	private Estado EstadoActual;
	
	private ArrayList<Jugador> jugadoresVictima = new ArrayList<Jugador>();
	
	public VentanaAlerta(ArrayList<Jugador> jugadoresVictima) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
		this.jugadoresVictima = jugadoresVictima;

		setResizable(false);
		setTitle("Love Letter");

		panel = new JPanel();
		panel.setLayout(null);

		etiqueta = new JLabel();
		etiqueta.setFont(new Font("Consolas", Font.PLAIN, 20));
		if( jugadoresVictima.size() == 0 ) {
			etiqueta.setText("No hay jugadores disponibles");
			etiqueta.setBounds(10, 11, 350, 28);
			boton = new JButton("�OK!");
			boton.setBounds(151, 200, 90, 25);
			boton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			panel.add(boton);
		}
		else
			etiqueta.setText("Seleccione Jugador Objetivo");
		etiqueta.setBounds(40, 11, 374, 28);

		panel.add(etiqueta);
		getContentPane().add(panel);
		
		for (int i = 0; i < jugadoresVictima.size(); i++) {
			boton = new JButton(jugadoresVictima.get(i).getNombre());
			boton.setBounds(151, desplazmientoY + 30 * i, 100, 23);
			
			boton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
<<<<<<< HEAD
					nombreSeleccionado = arg0.getActionCommand();
=======
					nombreVictima = arg0.getActionCommand();
					//setVisible(false);

>>>>>>> 7e9883b9f320f99b3767fad26f0de0d6ada5b2ed
				}
				
			});
			panel.add(boton);
			
		}
		
		setSize(400, 400);
		setLocationRelativeTo(null);
	}

	public Jugador getJugadorVictima() {
		for (int i = 0; i < jugadoresVictima.size(); i++) {
			if(jugadoresVictima.get(i).getNombre().equals(nombreSeleccionado)) {
				return jugadoresVictima.get(i);
			}
		}
		return null;
	}

}
