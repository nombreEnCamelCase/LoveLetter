package loveletter.Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import loveletter.Jugador;
import loveletter.Partida;

public class VentanaGanadorPartida extends JFrame {

	private JPanel panel;
	private JLabel etiqueta;
	private JLabel txtGanador;
	private JLabel texTablaDePuntuciacion;
	
	//private JButton botonSalirJuego;	
	
	private JLabel nameGanador;

	private JButton botonOtraPartida;
	private JButton botonSalir;
	private JLabel txtJugador;

	private JLabel name;
	
	
	private JLabel punt2;


	public VentanaGanadorPartida(ArrayList<Jugador> jugadores, Jugador ganadorDePartida) {
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Love Letter");
		
		setSize(380,471);
		setLocationRelativeTo(null);
		
		setVisible(true);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		setContentPane(panel);
		panel.setLayout(null);
		panel.setLayout(null);

		
		etiqueta = new JLabel();
		etiqueta.setBounds(28, 12, 181, 49);
		etiqueta.setFont(new Font("Consolas", Font.PLAIN, 20));
		etiqueta.setText("FIN DE PARTIDA");
		panel.add(etiqueta);
		
		txtGanador = new JLabel("Ganador");
		txtGanador.setFont(new Font("Consolas", Font.PLAIN, 13));
		txtGanador.setBounds(28, 93, 56, 14);
		panel.add(txtGanador);
		
		texTablaDePuntuciacion = new JLabel();
		texTablaDePuntuciacion.setText("Tabla de Puntuaciacion");
		texTablaDePuntuciacion.setFont(new Font("Consolas", Font.PLAIN, 20));
		texTablaDePuntuciacion.setBounds(28, 154, 249, 49);
		panel.add(texTablaDePuntuciacion);
		
		nameGanador = new JLabel(ganadorDePartida.getNombre());
		nameGanador.setBounds(147, 92, 62, 14);
		nameGanador.setFont(new Font("Consolas", Font.PLAIN, 13));
		panel.add(nameGanador);
		
		botonOtraPartida = new JButton("Otra Partida");
		botonOtraPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partida partida = new Partida();
				partida.comenzarJuego();
			}
		});
		botonOtraPartida.setBounds(28, 359, 122, 23);
		panel.add(botonOtraPartida);
		
		botonSalir = new JButton("Salir del Juego");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		botonSalir.setBounds(193, 359, 122, 23);
		panel.add(botonSalir);
		
		
		
		for (int i = 0; i < jugadores.size(); i++) {
			txtJugador = new JLabel(jugadores.get(i).getNombre());
			txtJugador.setFont(new Font("Consolas", Font.PLAIN, 13));
			txtJugador.setBounds(28, 214+43*i, 83, 14);
			
			for(int j=0; j<4;j++) {
				
				punt2 = new JLabel();
				punt2.setBounds(148+25*j, 214+43*i, 15, 14);
				
				ImageIcon fot = new ImageIcon("assets/other/dona.jpg");
				ImageIcon icono = new ImageIcon(fot.getImage().getScaledInstance(punt2.getWidth(), punt2.getHeight(), Image.SCALE_DEFAULT));
				name.setIcon(icono);
				
			}
			
			panel.add(txtJugador);
			panel.add(punt2);
			
		}
				
		
	}

}
