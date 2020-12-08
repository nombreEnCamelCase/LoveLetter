package loveletter.clientes;

public interface JugadorCargado {
	public void jugadorDesconectado(String ip, String nombre);
	public void obtenerNombreJugador(String ip, String nombre);
	//aca tendria que poner los demas metodos para enviar mensajes al servidor 
	//public void direccionJugador(String nombre, String dir);
}
