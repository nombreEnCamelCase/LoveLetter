package loveletter.Client;

public interface PlayerConnectionHandler {

	// Contiene los metodos para enviar mensajes al servidor desde cada jugador.

	public void jugadorDesconectado(String ip, String nombre);

	public void obtenerNombreJugador(String ip, String nombre);
}
