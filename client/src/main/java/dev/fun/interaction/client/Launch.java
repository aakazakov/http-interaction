package dev.fun.interaction.client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Launch {
	
	public static void main(String[] args) {
		
		try (Socket socket = new Socket("localhost", 8089)) {
			
			StringBuilder req = new StringBuilder();
			
			req.append("GET /req/hello HTTP/1.1").append("\r\n");
			req.append("Host: ").append("localhost:8089").append("\r\n");
			req.append("Accept: ").append("text/plain;charset=UTF-8").append("\r\n");
			req.append("Connection: ").append("close").append("\r\n");
			req.append("Content-Type: ").append("text/plain;charset=UTF-8").append("\r\n");
			req.append("\r\n");
			
			socket.getOutputStream().write(req.toString().getBytes());
			
			InputStream in = new BufferedInputStream(socket.getInputStream());
			int x;
			while((x = in.read()) != -1) {
				System.out.print((char) x);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
