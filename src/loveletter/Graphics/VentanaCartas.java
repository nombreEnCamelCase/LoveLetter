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

import java.awt.Font;
import javax.swing.JRadioButton;

public class VentanaCartas extends JFrame {

	private static final long serialVersionUID = 1779064557725749287L;
	private JPanel panel;
	private JLabel etiqueta, cantidad;
	private JButton boton;
	private int desplazmientoY = 50;
	private String cartaSeleccionada;
	private static String []cartas = {	"Sacerdote","2",
										"Baron","2",
										"Mucama","2",
										"Principe","2",
										"Rey","1",
										"Condesa","1",
										"Princesa","1"};
	public VentanaCartas() {
		setResizable(false);
		setTitle("Lista De Cartas");
		setDefaultCloseOperation(0); 
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setLayout(null);

		etiqueta = new JLabel();
		etiqueta.setFont(new Font("Consolas", Font.PLAIN, 20));
		etiqueta.setText("Seleccione carta");
		etiqueta.setBounds(110, 11, 230, 28);

		panel.add(etiqueta);
		getContentPane().add(panel);
		
		for (int i = 0; i < cartas.length; i++) {
			boton = new JButton(cartas[i]);
			boton.setBounds(151, desplazmientoY + 15* i, 100, 23);
			cantidad = new JLabel(cartas[++i]);
			cantidad.setBounds(255, desplazmientoY + 15 * ((i)-1) , 100, 23);
			boton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					cartaSeleccionada = arg0.getActionCommand();
					dispose();
				}

			});
			panel.add(cantidad);
			panel.add(boton);
		}

		setSize(400, 400);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public String getCartaSeleccionada() {
		return cartaSeleccionada;
	}
}
