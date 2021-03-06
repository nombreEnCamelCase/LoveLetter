package loveletter.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import loveletter.Jugador;
import java.awt.Font;

public class VentanaAlerta extends JFrame {

	private static final long serialVersionUID = 1779064557725749287L;
	private JPanel panel;
	private JLabel etiqueta;
	private JButton boton;
	private int desplazmientoY = 50;
	private String nombreSeleccionado;
	//private Estado EstadoActual;
	
	private ArrayList<Jugador> jugadoresVictima = new ArrayList<Jugador>();

	public VentanaAlerta(ArrayList<Jugador> jugadoresVictima) {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.jugadoresVictima = jugadoresVictima;

		setResizable(false);
		setTitle("Love Letter");
		setDefaultCloseOperation(0);

		panel = new JPanel();
		panel.setLayout(null);

		etiqueta = new JLabel();
		etiqueta.setFont(new Font("Consolas", Font.BOLD, 20));
		if (jugadoresVictima.size() == 0) {
			etiqueta.setText("No hay jugadores disponibles");
			etiqueta.setBounds(5, 11, 310, 28);
			boton = new JButton("Continuar");
			boton.setBounds(150, 60, 90, 25);
			boton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					nombreSeleccionado = null;
					dispose();
				}
			});
			panel.add(boton);
			setSize(380, 150);
		} else {
			etiqueta.setText("Aplicar efecto a...");
			setSize(300, 250);
		}
			
		
		etiqueta.setBounds(40, 11, 374, 28);

		panel.add(etiqueta);
		getContentPane().add(panel);

		for (int i = 0; i < jugadoresVictima.size(); i++) {
			boton = new JButton(jugadoresVictima.get(i).getNombre());
			boton.setBounds(100, desplazmientoY + 30 * i, 100, 23);

			boton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					nombreSeleccionado = arg0.getActionCommand();
				}

			});
			panel.add(boton);

		}
		setLocationRelativeTo(null);
	}

	public Jugador getJugadorVictima() {
		for (int i = 0; i < jugadoresVictima.size(); i++) {
			if (jugadoresVictima.get(i).getNombre().equals(nombreSeleccionado)) {
				return jugadoresVictima.get(i);
			}
		}
		return null;
	}

}
