package by.epam.tasks.task3.client;

import java.io.IOException;

public class ArchiveClient {
    
    private ConnectionManager connection;
    private Student student;
    private User user;
    
    public ArchiveClient() {
	connection = new ConnectionManager();
	connection.connect();
	student = new Student();
	user = new User();
    }
    
    public void getFile() {	
	System.out.println("Client<< Enter case number");
	int id = MenuUtil.scannerInt("Case number: ");
		
	try {
            connection.sendMessage("getfile " + id);
            connection.waitForAnswer();
            student = (Student) connection.receiveFile();
			
            if (student.getId() != 0) {
		System.out.println(student.toString());
            } else {
		System.out.println("Client<< There is no student with this ID.");
            }
	} 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
	} 
        catch (IOException e) {
            e.printStackTrace();
	}
    }
    
    public void exit() {
	System.out.println("Client<< Finishing work...");
	try {
	    connection.sendMessage("exit");
	} catch (IOException e) {
            e.printStackTrace();
	}
    }
    
}