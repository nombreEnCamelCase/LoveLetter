package loveletter.Server;
import java.util.ArrayList;
import loveletter.Jugador;
import loveletter.Client.PlayerHandle;


public interface AccionesServidor {
	/**
	 * La interface AccionesServidor contiene los metodos que van a ser ejecutados por el servidor .
	 */
	default public void recibirNombre(String nombre){}
	public void nombreOK();
	public void nombreMal();
	default public void enviarListaJugadores(ArrayList<Jugador> listaJugadores){}
	default public void listaJugadores(){}
	default public void cambioListaJugadores(){}
	default public void enviarJugada(String carta) {};
	default public void salidaJugador(PlayerHandle manejoJugador){}
	default public void perderRonda(){}
	default public void enviarPuntaje(String nombre, int puntaje){}
}
