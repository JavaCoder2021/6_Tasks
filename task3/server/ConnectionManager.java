package by.epam.tasks.task3.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ConnectionManager {
	private Socket clientSocket;
	private BufferedReader in;
	private BufferedWriter out;
	
	public ConnectionManager(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	
	public void connect() throws IOException {
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
		System.out.println("Info: Connection created");
	}
	
	public void disconnect() {
		try {
                    clientSocket.close();
                    in.close();
                    out.close();
		} catch (IOException e) {
                    System.out.println("ERROR: Close connection error");
                    e.printStackTrace();
		}
		
	}
        
	public void waitForMessage() {
		System.out.println("Info<< Waiting for a message from a client...");
		try {
			while(clientSocket.getInputStream().available() == 0) {
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
		System.out.println("Info<< Accept the message");
		try {
			while (in.ready()) {
				System.out.println("Info<< Accept the line");
				message.append(in.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return message.toString();
	}
	
	public Object receiveFile() throws IOException, ClassNotFoundException {
		System.out.println("Info<< Accept the file...");
		ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
		
		Object obj = ois.readObject();
		
		System.out.println("Info<< File accepted...");
		
		return obj;
	}
	
	public void sendFile(Object obj) throws IOException {
		System.out.println("Info<< Sending a file...");
		ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
		
		oos.writeObject(obj);
		oos.flush();
		
		System.out.println("Info<< File sent...");
	}

}