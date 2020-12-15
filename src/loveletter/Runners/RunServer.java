package loveletter.Runners;

import loveletter.Screens.ServerMonitoringScreen;
import loveletter.Server.GameServer;

public class RunServer {
	private final static int PORT = 20000;
	public static void main(String[] args) {
		try {
			ServerMonitoringScreen screenServer = new ServerMonitoringScreen(PORT);
			screenServer.cargarInterfaz();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
