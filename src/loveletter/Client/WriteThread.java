package loveletter.Client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

// Este thread tiene la responsabilidad de leer desde el input que realice el usuario y enviarlo al servidor.
// Esto corre infitamente en un demonio, hasta que el usuario seleccione '-quit' para desconectarse y eliminar el thread.

public class WriteThread extends Thread implements AccionesCliente {
	private PrintWriter writer;
	private Socket socket;
	private PlayerClient client;
	private Scanner localScan;

	public WriteThread(Socket socket, PlayerClient client) {
		this.socket = socket;
		this.client = client;
		this.localScan = new Scanner(System.in);

		try {
			OutputStream output = socket.getOutputStream();
			writer = new PrintWriter(output, true);
		} catch (IOException ex) {
			System.out.println("Error obteniendo el output stream: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void run() {

		System.out.println(this.client.getUserName()+" - Ha entrado a la sala de juego");

		String text, msje;
		
		do {
			text = getLineFromUserByInput("");
			if (isValidMessage(text)) {
				msje = "[yo]: " + text;
				System.out.println(msje);
				writer.println(text);
			}

		} while (!text.equals("-quit"));

		try {
			this.localScan.close();
			this.socket.close();
		} catch (IOException ex) {

			System.out.println("Error al escribir al server " + ex.getMessage());
		}
	}

	public String getLineFromUserByInput(String inputLabel) {
		String resultLine = "";
		try {

			if (!inputLabel.equals("") && !inputLabel.equals("\n"))
				System.out.print(inputLabel + ": ");

			resultLine = this.localScan.nextLine();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return resultLine;
	}

	private boolean isValidMessage(String message) {
		return !message.equals("") && !message.equals("\n") && !message.equals("\r");
	}

}