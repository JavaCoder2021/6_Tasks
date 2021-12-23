/*
 * !Выполнено не полностью
 * Попробуйте решить данную задачу хотя бы на 50%. 
 * Задание 3: создайте клиент-серверное приложение “Архив”.  
 *  
 * Общие требования к заданию: 
 *  
 * •  В архиве хранятся Дела (например, студентов). Архив находится на сервере. 
 * •  Клиент, в зависимости от прав, может запросить дело на просмотр, 
 * внести в него изменения, или создать новое дело. 
 * Требования к коду лабораторной работы: 
 * •  Для реализации сетевого соединения используйте сокеты. 
 * •  Формат хранения данных на сервере – xml-файлы. 
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
