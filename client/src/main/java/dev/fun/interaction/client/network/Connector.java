package dev.fun.interaction.client.network;

import java.io.IOException;
import java.net.Socket;

public class Connector {

	private final String host;
	private final int port;
	
	private Socket socket;
	
	public Socket getSocket() {
		return socket;
	}
	
	public Connector(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void connect() throws IOException {
		socket = new Socket(host, port);
		System.out.println("Client has been connected");
	}
	
	public void disconnect() throws IOException {
		socket.close();
		System.out.println("Client has been disconnected");
	}
	
}
