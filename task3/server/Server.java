package by.epam.tasks.task3.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedList;

public class Server {
    
	private static final int PORT = 4888;
	private ConnectionManager connection;    
        
	public void start() {
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
		System.out.println("Info: Server started");
		connection = new ConnectionManager(serverSocket.accept());
		connection.connect();
		System.out.println("Info: Connection to the server has been created");
            } catch (IOException e) {
		e.printStackTrace();
            } 
	}
        
	public String[] recieveCommand() {
		connection.waitForMessage();
		return connection.recieveMessage().split(" ");
	}
        
	public void getFile(String[] message, LinkedList<Student> students) {
            int id;
            try {
		if (message.length < 2) {
                    System.out.println("Info: Invalid command for file request");
                    connection.sendFile(new Student());
                    return;
		}
		id = Integer.parseInt(message[1]);
                for (Student student : students)
                    if (student.getId() == id) {
                        connection.sendFile(student);
                        break;
                    }		
            } 
            catch (IOException e) {
		e.printStackTrace();
            } 
            catch (NumberFormatException e) {
		e.printStackTrace();
		try {
                    connection.sendFile(new Student());
		} 
                catch (IOException e1) {
                    e1.printStackTrace();
		}	
            }
	}
        
	public void exit() {
            connection.disconnect();
	}
    
}