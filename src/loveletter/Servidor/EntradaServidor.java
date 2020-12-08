package loveletter.Servidor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EntradaServidor {
	//SE ENCARGA DE MANEJAR LA ENTRADA DE DATOS DEL CLIENTE AL SERVIDOR.
	
	//ManejoJugador manejoJugador;
	InputStream entrada;
	
	public EntradaServidor(InputStream entrada/*, ManejoJugador manejoJugador*/) throws IOException{
		this.entrada= entrada;
		//this.manejoJugador=manejoJugador;
	}
	
	public void doRun() throws IOException{
		String nombre,dir;
		try(BufferedReader b= new BufferedReader(new InputStreamReader(entrada))){
			while(true) {
				String linea= b.readLine();
				switch(linea) {
				case "NOMBRE":
					nombre= b.readLine();
					//manejoJugador.recibirNombre();
					break;
				case "JUGADORES":
					//manejoJugador.listaJugadores();
					//manejoJugador.listaJugadores();
					break;
				case "TECLA":
					dir=b.readLine();
					//manejoJugador.cambiarDireccion(dir);
					break;
				default:
				}
			}
		}
	}
	
}
