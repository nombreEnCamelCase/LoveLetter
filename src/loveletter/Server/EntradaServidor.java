package loveletter.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import loveletter.Client.UserThread;



public class EntradaServidor {
	/**
	 * La clase EntradaServidor maneja la entrada de datos del cliente al servidor.
	 */
	UserThread manejoJugador;
	InputStream entrada;
	
	public EntradaServidor( InputStream entrada, UserThread manejoJugador) throws IOException{
		this.entrada = entrada;
		this.manejoJugador = manejoJugador;
	}
	
	public void doRun() throws IOException{
		String nombre, dir;
		try(BufferedReader b = new BufferedReader(new InputStreamReader(entrada))){
			while(true){
				String linea = b.readLine();
				switch (linea){
				case "NOMBRE":
					nombre = b.readLine();
					manejoJugador.recibirNombre(nombre);
					break;
				case "JUGADORES":
					manejoJugador.listaJugadores();
//					manejoJugador.nuevaVibora();
					break;
				case "CARTA":
					dir=b.readLine();
					manejoJugador.jugarCarta(dir);
					break;
				default :
				}
			}
		}
	}
}
