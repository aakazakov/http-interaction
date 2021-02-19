package dev.fun.interaction.client;

import java.io.IOException;

import dev.fun.interaction.client.network.Connector;

public class Launch {
	
	public static void main(String[] args) {
		
		Connector connector = new Connector("localhost", 8089);
		
		try {
			connector.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// TODO: ...
		
		try {
			connector.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
