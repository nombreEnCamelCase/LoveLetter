package loveletter.Client;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import loveletter.Carta;
import loveletter.Server.AccionesServidor;
import loveletter.Server.EntradaServidor;
import loveletter.Server.SalidaServidor;

// Este es un thread que se encarga de administrar a los jugadores desde el svr

@SuppressWarnings("unused")
public class UserThread implements Runnable, AccionesServidor {

	private final Socket socketJugador;
	private SalidaServidor salidaServidor;
	private EntradaServidor entradaServidor;
	private String nombre = "";
	private Carta cartaJugada;
	private int puntaje;
	private PlayerConnectionHandler logger = null;
	private boolean detener = false;

	private enum EstadoJugador {
		INICIO, LOGUEADO
	}

	private EstadoJugador estado = EstadoJugador.INICIO;

	public UserThread(Socket socketJugador, PlayerConnectionHandler logger) throws IOException {
		this.socketJugador = socketJugador;
		this.logger = logger;
		this.puntaje = 0;
	}

	public int getPuntaje() {
		return this.puntaje;
	}

	public String getNombre() {
		return this.nombre;
	}

	@Override
	public void run() {
		try (Socket s1 = socketJugador) {
			salidaServidor = new SalidaServidor(s1.getOutputStream());
			entradaServidor = new EntradaServidor(s1.getInputStream(), this);
			entradaServidor.doRun();
		} catch (IOException e) {
			if (!detener) {
				finalizar();
			}
		}

	}

	public synchronized void finalizar() {
		if (!detener) {
			detener = true;
			try {
				socketJugador.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (estado == EstadoJugador.LOGUEADO)
				// Juego.eliminarJugador(nombre);
				logger.jugadorDesconectado(socketJugador.toString(), nombre);
		}
	}

	@Override
	public void recibirNombre(String nombre) {
		String nuevoNombre = nombre;
//		if(Juego.salidaUsuario(nombre) || nombre.equals("null") || nombre.length() == 0){
//			nombreMal();
//			finalizar();
//			
//		}else{
//			nombreOK();
//			if(estado == EstadoJugador.INICIO){
//				this.nombre=nombre;
//				Juego.agregarJugador(nuevoNombre, this);
//			}
//		}

	}

	@Override
	public void nombreOK() {
		salidaServidor.nombreOK();
	}

	@Override
	public void nombreMal() {
		salidaServidor.nombreMal();

	}

	@Override
	public void listaJugadores() {
		//salidaServidor.enviarListaJugadores(Juego.getNombreJugadores());

	}

	@Override
	public void salidaJugador(UserThread manejoJugador) {
		// salidaServidor.limpiarVibora(manejoJugador.getCuerpoVibora());
	}

	@Override
	public void enviarPuntaje(String nombre, int puntaje) {
		salidaServidor.enviarPuntaje(nombre, puntaje);
	}

	@Override
	public void jugarCarta(String dir) {
		// TODO Auto-generated method stub

	}

	@Override
	public void jugadorPierde() {
		// TODO Auto-generated method stub

	}

}
