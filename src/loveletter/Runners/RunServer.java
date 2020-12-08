package loveletter.Runners;

import loveletter.Screens.ServerMonitoringScreen;
import loveletter.Server.GameServer;

public class RunServer {

	public static void main(String[] args) {

		int port = 20000;
		ServerMonitoringScreen screenServer = new ServerMonitoringScreen(new GameServer(port));
		screenServer.cargarInterfaz();
//		int port = 20000;
//
//		try {
//			GameServer server = new GameServer(port);
//			server.execute();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
