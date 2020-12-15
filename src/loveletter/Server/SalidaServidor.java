package loveletter.Server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;


@SuppressWarnings("unused")
public class SalidaServidor implements AccionesServidor {
	/**
	 * La clase SalidaServidor maneja la salida de datos del servidor hacia el cliente.
	 */
	PrintWriter os;
	
	public SalidaServidor(OutputStream salida) throws IOException{
		this.os = new PrintWriter(salida, true);
	}

	
	@Override
	public void nombreOK() {
		os.println("NOMBRE OK");
		
	}

	@Override
	public void nombreMal() {
		os.println("NOMBRE MAL");
		
	}


	@Override
	public void jugadorPierde() {
		// TODO Auto-generated method stub
		
	}

}
