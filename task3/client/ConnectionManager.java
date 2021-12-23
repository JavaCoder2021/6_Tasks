package by.epam.tasks.task3.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ConnectionManager {
    
	private static final String HOST = "localhost";
	private static final int PORT = 4888;
	
	private Socket socket;
	private BufferedReader in;
	private BufferedWriter out;
	
	public ConnectionManager() {}
	
	public void connect() {
		try {
			System.out.println("Client<< Connecting to the server...");
			socket = new Socket(HOST, PORT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			System.out.println("Client<< Connection completed");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void sendMessage(String message) throws IOException {
		out.write(message);
		out.newLine();
		out.flush();
		try {
                    Thread.sleep(2000);
		} catch (InterruptedException e) {
                    e.printStackTrace();
		}
		System.out.println("Client<< Message sent...");
	}
	
	
	public void waitForAnswer() {
		System.out.println("Client<< Waiting for a response from the server...");
		try {
			while (socket.getInputStream().available() == 0) {
                            Thread.sleep(1500);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String recieveMessage() {
		StringBuilder message = new StringBuilder();
		
		try {
                    while (in.ready()) {
                        message.append(in.readLine());
                    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return message.toString();
	}
	
	public Object receiveFile() throws IOException, ClassNotFoundException {
		System.out.println("Client<< Accept the file...");
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		
		Object obj = ois.readObject();
		
		System.out.println("Client<< File accepted...");
		
		return obj;
	}
	
	public void sendFile(Object obj) throws IOException {
		System.out.println("Client<< Sending a file...");
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		
		oos.writeObject(obj);
		oos.flush();
		System.out.println("Client<< File sent...");
	}
	
	public void close() throws IOException {
		in.close();
		out.close();
		socket.close();
	}

}