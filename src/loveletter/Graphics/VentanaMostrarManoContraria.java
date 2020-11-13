package loveletter.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaMostrarManoContraria extends JFrame {

	private JPanel contentPane;
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
		
		setSize(380,370);
		setLocationRelativeTo(null);		
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		setContentPane(panel);
		panel.setLayout(null);
		
		etiqueta = new JLabel();
		etiqueta.setBounds(58, 11, 291, 49);
		etiqueta.setFont(new Font("Consolas", Font.PLAIN, 20));
		etiqueta.setText("Mano de "+objetivo.getNombre());
		panel.add(etiqueta);
		
		botonContinuar = new JButton("Continuar...");
		botonContinuar.setBounds(117, 307, 118, 23);
		botonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirmacion=false;
				//dispose();
			}
		});
		panel.add(botonContinuar);
		
		punt2 = new JLabel();
		punt2.setBounds(107, 71, 142, 222);
		
		ImageIcon fot = new ImageIcon("assets/other/dona.jpg");
		ImageIcon icono = new ImageIcon(fot.getImage().getScaledInstance(punt2.getWidth(), punt2.getHeight(), Image.SCALE_DEFAULT));
		punt2.setIcon(icono);
		panel.add(punt2);
		
}
}
