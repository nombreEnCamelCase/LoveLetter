package loveletter.Servidor;
import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;


public class SalidaServidor implements AccionesServior{
	//administra la salida de datos del servidor hacia el cliente
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
		// TODO Auto-generated method stub
		
	}

}
