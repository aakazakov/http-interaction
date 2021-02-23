package dev.fun.interaction.client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Launch {
	
	public static void main(String[] args) {
		
		get();
		post();
		
	}
	
	static void get() {
		try (Socket socket = new Socket("localhost", 8089);
				InputStream in = new BufferedInputStream(socket.getInputStream());
				OutputStream out = socket.getOutputStream();) {
			
			StringBuilder req = new StringBuilder();
			
			req.append("GET /req/get/hello HTTP/1.1").append("\r\n");
			req.append("Host: ").append("localhost:8089").append("\r\n");
			req.append("Accept: ").append("application/json;charset=UTF-8").append("\r\n");
			req.append("Connection: ").append("close").append("\r\n");
			req.append("\r\n");
			
			out.write(req.toString().getBytes());
			
			int x;
			while((x = in.read()) != -1) {
				System.out.print((char) x);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	static void post() {
		try (Socket socket = new Socket("localhost", 8089);
				InputStream in = new BufferedInputStream(socket.getInputStream());
				OutputStream out = socket.getOutputStream();) {
			
			StringBuilder req = new StringBuilder();
			
			String payload = "{\n\s\s\s\s\"value\": \"world\"\n}";
			
			req.append("POST /req/post HTTP/1.1").append("\r\n");
			req.append("Host: ").append("localhost:8089").append("\r\n");
			req.append("Accept: ").append("application/json;charset=UTF-8").append("\r\n");
			req.append("Connection: ").append("close").append("\r\n");
			req.append("Content-Type: ").append("application/json;charset=UTF-8").append("\r\n");
			req.append("Content-Length: ").append(payload.getBytes().length).append("\r\n");
			req.append("\r\n");
			req.append(payload);
			
			out.write(req.toString().getBytes());
			
			int x;
			while((x = in.read()) != -1) {
				System.out.print((char) x);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
