package loveletter.Server;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.JTextArea;

import loveletter.Jugador;
import loveletter.Partida;
import loveletter.Client.PlayerConnectionHandler;
import loveletter.Client.UserThread;
import loveletter.Screens.ServerMonitoringScreen;

public class GameServer extends Thread {
	private int port;
	private final static int ANCHO = 700;
	private final static int ALTO = 640;
	private final static int ALTO_LOG = 520;
	private final static int ANCHO_LOG = ANCHO - 25;
	private int cantJugadoresConectados;
	private boolean detenerServidor = false;
	private boolean comenzarPartida = false;
	private PlayerConnectionHandler logger = null;
	private Queue<Jugador> colaEnEspera = new PriorityQueue<Jugador>();
	public static Partida partida;

	public GameServer(int port) {
		this.port = port;
		this.colaEnEspera = new PriorityQueue<Jugador>();
	}

	@Override
	public void run() {
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			
			ServerMonitoringScreen.addLogMessage("Iniciando el servidor...");
			ServerMonitoringScreen.addLogMessage("Escuchando puerto: " + port);
			
			while (!this.detenerServidor) {
				Socket socketJugador = serverSocket.accept();
				ServerMonitoringScreen.addLogMessage("Nuevo usuario conectado.");
				ServerMonitoringScreen.addLogMessage("El cliente : " + socketJugador.getInetAddress().getHostAddress() + " se ha conectado.");
				Jugador newUser = new Jugador(socketJugador.getInetAddress().getHostAddress(), colaEnEspera.size() + 1,
						new UserThread(socketJugador, logger));

				if (cantJugadoresConectados < 2 ) {
					this.colaEnEspera.add(newUser);
					cantJugadoresConectados++;
				} else {
					// Creamos partida
					partida = new Partida(1);
					partida.addNewPlayer(newUser);
					cantJugadoresConectados++;
					//partida.comenzarJuego();
					new Thread(newUser.getUserConnection()).start();
					while (!this.colaEnEspera.isEmpty()) {
						Jugador newPlayer = this.colaEnEspera.poll();
						new Thread(newPlayer.getUserConnection()).start();
						partida.addNewPlayer(newPlayer);
					}
					// Creo que esto no estaria aca.
					partida.comenzarJuego();
				}
			}

		} catch (IOException ex) {
			ServerMonitoringScreen.addLogMessage("Error en el servidor: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void quitarJugador() {
		this.cantJugadoresConectados--;
	}
	public synchronized void detenerServidor() {
		this.detenerServidor = true;
	}

	public synchronized void comenzarPartida() {
		this.comenzarPartida = true;
	}

}