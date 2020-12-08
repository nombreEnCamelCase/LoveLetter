package loveletter.clientes;

import java.awt.Color;
import java.net.Socket;

import loveletter.clientes.JugadorCargado;
import loveletter.Servidor.AccionesServior;
import loveletter.Servidor.EntradaServidor;
import loveletter.Servidor.SalidaServidor;


@SuppressWarnings("unused")
public class ManejoJugador implements Runnable, AccionesServior{
	
	
	private final Socket socketJugador = new Socket();
	private SalidaServidor salidaServidor;
	private EntradaServidor entradaServidor;
	private String nombre = "";
	private int puntaje;
	private JugadorCargado logger = null;
	private boolean detener = false;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nombreOK() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nombreMal() {
		// TODO Auto-generated method stub
		
	}

}
