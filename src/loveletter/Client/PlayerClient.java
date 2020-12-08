package loveletter.Client;

import java.net.*;
import java.util.LinkedList;
import java.util.List;


import java.io.*;

// Escribir '-quit' para cerrar atencion de cliente.
public class PlayerClient {
	private String hostname;
	private int port = 20000;
	private String userName;

	
	public PlayerClient(String hostname, int port, String username) {
		this.hostname = hostname;
		this.port = port;
		this.userName = username;
	}

	public void execute() {
		try {
			Socket socket = new Socket(hostname, port);

			System.out.println("Se ha conectado a la sala de chat.");

			(new ReadThread(socket, this)).start();
			(new WriteThread(socket, this)).start();

		} catch (UnknownHostException ex) {
			System.out.println("Servidor no encontrado: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("I/O Error: " + ex.getMessage());
		}

	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return this.userName;
	}

}