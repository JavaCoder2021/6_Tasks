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
package by.epam.tasks.task3.client;

import by.epam.tasks.task3.client.misc.Hesh;
import by.epam.tasks.task3.client.misc.EmailValidator;
import by.epam.tasks.task3.client.misc.UserNameValidator;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        LinkedList<User> users = TextFileReader.readUsersFile();  
        //LinkedList<Student> students = TextFileReader.readStudentsFile();
	User user;        
        int USER_TYPE = -1;
        String login = "user";
        String password;  
        String passwordHash;  
        int choice = 0;
        Scanner input = new Scanner(System.in);
        
        ArchiveClient client = new ArchiveClient();
        
        while (true) {
            
            /** Menu for NOT_REGISTERED */    
            if (USER_TYPE == -1) {
            
                MenuUtil.menuTextNotRegistered();
                     
                do {

                    if (input.hasNextInt()) {
                        choice = input.nextInt();
                    } else {
                        input.next();
                    }
                } while (choice < 0);                              
                
                if (choice == 0) {
                    client.exit();
                    break;
                }
                if (choice < 0 || choice > 2) {
                    System.out.println("Incorrect choose!");
                    continue;
                }
                
                input.nextLine();
                      
                switch (choice) {
                    case 1:                     
                        //----------Input data---------------
                        System.out.println("Log in:");                        
                        
                        System.out.print("Input Login: "); 
                        login = input.nextLine();
                        System.out.print("Input Password: ");
                        password = input.nextLine();
                        passwordHash = Hesh.getHesh(password); 
                        Boolean logged = false;
                        for (User loginUser : users)
                            if ((loginUser.getLogin().equals(login)) && (loginUser.getPassword().equals(passwordHash))) {    
                                user = loginUser; 
                                USER_TYPE = user.getUserType(); 
                                logged = true;
                            }
                        if (!logged)
                            System.out.println("Incorrect choose!");
                        break;
                    case 2: 
                        //----------Input data---------------
                        System.out.println("Registration:");
                    
                        int userType = MenuUtil.scannerIntNotRegistered("Input User type (0 - USER ; 1 - ADMIN): ");
                    
                        do {
                            System.out.print("Input Login: ");                       
                            login = input.nextLine();
                        }
                        while (!UserNameValidator.validate(users, login));  
                    
                        System.out.print("Input Password: ");
                        password = input.nextLine();
                        passwordHash = Hesh.getHesh(password);
                    
                        String email;
                        do {
                            System.out.print("Input E-mail: ");                        
                            email = input.nextLine();
                        }
                        while (!EmailValidator.validate(email));  
                        //----------Create user-----------------
                        user = new User(userType, login, passwordHash, email);
                        users.add(user);
                        USER_TYPE = user.getUserType();                    
                        TextFileReader.appendUsersFile(user.toString());
                        break;                          
                }
                   
            }
            
            /** Menu for REGISTERED */    
            if (USER_TYPE == 0) {
            
                MenuUtil.menuTextRegistered(login);
                
                do {

                    if (input.hasNextInt()) {
                        choice = input.nextInt();
                    } else {
                        input.next();
                    }
                } while (choice < 0);                              
                
                if (choice == 0) {
                    client.exit();
                    break;
                }
                if (choice < 0 || choice > 1) {
                    System.out.println("Incorrect choose!");
                    continue;
                }
                
                input.nextLine();  
                
                switch (choice) {
                    case 1:       
                        client.getFile(); 
                        break;
                }
                
            }
            
            /** Menu for ADMIN */    
            if (USER_TYPE == 1) {
            
                MenuUtil.menuTextAdmin(login); 
                
                do {

                    if (input.hasNextInt()) {
                        choice = input.nextInt();
                    } else {
                        input.next();
                    }
                } while (choice < 0);                              
                
                if (choice == 0) {
                    client.exit();
                    break;
                }
                if (choice < 0 || choice > 1) {
                    System.out.println("Incorrect choose!");
                    continue;
                }
                
                input.nextLine();  
                
                switch (choice) {
                    case 1:       
                        client.getFile();     
                        break;
                }
                
            }
            
        }
        
    }
    
}
