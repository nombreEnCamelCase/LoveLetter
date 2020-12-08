package loveletter.Server;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.JTextArea;

import loveletter.Jugador;
import loveletter.Partida;
import loveletter.Client.PlayerConnectionHandle;
import loveletter.Client.PlayerHandle;


public class GameServer extends Thread {
	private int port;
	private JTextArea log;
	private final static int ANCHO = 700;
	private final static int ALTO = 640;
	private final static int ALTO_LOG = 520;
	private final static int ANCHO_LOG = ANCHO - 25;
	private static int cantJugadoresConectados;
	private boolean detenerServidor = false;
	private boolean comenzarPartida = false;
	private PlayerConnectionHandle logger = null;
	private Queue<PlayerHandle> colaEnEspera = new PriorityQueue<PlayerHandle>();
	ArrayList<Jugador> jugadoresEnSala = new ArrayList<Jugador>();
	
	// Usamos set para no dejar repetir usuarios.
	private Set<String> userNames = new HashSet<>();
	private Set<UserThread> userThreads = new HashSet<>();
	
	public GameServer(int port) {
		this.port = port;
		this.colaEnEspera = new PriorityQueue<PlayerHandle>();
	}

	@Override
	public void run() {
		try (ServerSocket serverSocket = new ServerSocket(port)) {

			log.append("Iniciando el servidor..." + System.lineSeparator());
			log.append("Escuchando puerto: "+port+ System.lineSeparator());
			while (!this.detenerServidor) {
				Socket socketJugador = serverSocket.accept();
				log.append("Nuevo usuario conectado.");
				log.append("El cliente : " + socketJugador.getInetAddress().getHostAddress() + " se ha conectado" + System.lineSeparator());
				UserThread newUser = new UserThread(socketJugador, this);
				userThreads.add(newUser);
				newUser.start();
				cantJugadoresConectados++;
				
				// Tengo que encontrar la forma de mandarle esto.
				//jugadoresEnSala.add(new Jugador(socketJugador.))
				if(cantJugadoresConectados<2) {
					this.colaEnEspera.add(new PlayerHandle(socketJugador, logger));
				}
				else {
//					Juego.iniciarMapa();
					if(this.comenzarPartida) {
						Partida partida = new Partida(1);
						partida.comenzarJuego();
						new Thread(new PlayerHandle(socketJugador, logger)).start();
						while(!this.colaEnEspera.isEmpty()) {
							new Thread(this.colaEnEspera.poll()).start();
						}
					}
					
				}
			}

		} catch (IOException ex) {
			log.append("Error en el servidor: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	// Envia mensaje desde un usuario hacia otros.
	public void broadcast(String message, UserThread excludeUser) {
		
		for (UserThread aUser : userThreads) {
			if (aUser != excludeUser) {
				aUser.sendMessage(message);
			}
		}
	}
	

	// Guardamos el nickname del nuevo usuario conectado.
	public void addUserName(String userName) {
		userNames.add(userName);
	}

	// Cuando el usuario se desconecta lo revomeos de la lista de nicknames.
	public void removeUser(String userName, UserThread aUser) {
		boolean removed = userNames.remove(userName);
		if (removed) {
			userThreads.remove(aUser);
			log.append("El usuario [" + userName + "] ha salido.");
		}
	}

	public Set<String> getUserNames() {
		return this.userNames;
	}
	
	// Retornamos verdadero si existe al menso algun usuario.
	public boolean hasUsers() {
		return !this.userNames.isEmpty();
	}
	
	public JTextArea getLog() {
		return this.log;
	}
	
	public void setLog(final JTextArea log) {
		this.log = log;
	}

	public synchronized void detenerServidor(){
		this.detenerServidor=true;
	}
}