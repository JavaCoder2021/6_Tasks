/*
 * !��������� �� ���������
 * ���������� ������ ������ ������ ���� �� �� 50%. 
 * ������� 3: �������� ������-��������� ���������� ������.  
 *  
 * ����� ���������� � �������: 
 *  
 * �  � ������ �������� ���� (��������, ���������). ����� ��������� �� �������. 
 * �  ������, � ����������� �� ����, ����� ��������� ���� �� ��������, 
 * ������ � ���� ���������, ��� ������� ����� ����. 
 * ���������� � ���� ������������ ������: 
 * �  ��� ���������� �������� ���������� ����������� ������. 
 * �  ������ �������� ������ �� ������� � xml-�����. 
 */
package by.epam.tasks.task3.server;

import java.util.Arrays;
import java.util.LinkedList;
import by.epam.tasks.task3.server.module.User;
import by.epam.tasks.task3.server.module.TextFileReader;

public class Main {
    
    public static void main(String[] args) {

        Server server = new Server();
        server.start();
        
        LinkedList<User> users = TextFileReader.readUsersFile();  
        LinkedList<Student> students = TextFileReader.readStudentsFile();
        
        String[] command = {""};
		
        while (!command[0].equals("exit")) {
            
            command = server.recieveCommand();
                        
            System.out.println("Info: The team came " + Arrays.toString(command));
			
            switch (command[0].toLowerCase()) {
		case "signin":
                    //server.signIn();
                    break;
                case "login":
                    //server.login(command);
                    break;
		case "getfile":
                    server.getFile(command, students);
                    break;
		case "createfile":
                    //server.createFile();
                    break;
		case "editfile":
                    //server.editFile(command);
                    break;
		case "exit":
                    server.exit();
                    continue;
		default:
                    System.out.print("Info: Unknown team");
                    break;
            }
            
	}
        
    }    
    
}