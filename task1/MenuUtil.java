package by.epam.tasks.task1;

import java.util.Scanner;

public class MenuUtil {
    
    /**
     * Text of menu for NOT_REGISTERED
     */    
    public static void menuTextNotRegistered() { 
        System.out.print(
            "\n" + 
            "[NOT_REGISTERED] \n" +
            "Select a menu item: \n" +
            "0. Exit \n" +
            "1. Log in \n" + 
            "2. Registration \n" +                     
            "\n"
        );   
    } 
    
    /**
     * Text of menu for REGISTERED
     * @param login
     */    
    public static void menuTextRegistered(String login) {
        System.out.print(
            "\n" + 
            "[REGISTERED] " + login + " \n" +
            "Select a menu item: \n" +
            "0. Exit \n" +
            "1. View books \n" + 
            "2. Search for books by Id \n" +       
            "3. Search for books by Title \n" +     
            "4. Search for books by Author \n" +   
            "5. Search for books by Publisher \n" +   
            "6. Search for books by Year \n" +    
            "7. Suggest a book \n" +                       
            "\n"
        );   
    }  
    
    /**
     * Text of menu for ADMIN
     * @param login
     */    
    public static void menuTextAdmin(String login) {
        System.out.print(
            "\n" + 
            "[ADMIN] " + login + " \n" +
            "Select a menu item: \n" +
            "0. Exit \n" +
            "1. View books \n" + 
            "2. Search for books by Id \n" +       
            "3. Search for books by Title \n" +     
            "4. Search for books by Author \n" +   
            "5. Search for books by Publisher \n" +   
            "6. Search for books by Year \n" + 
            "7. Add book \n" +                    
            "8. Delete book by Id \n" +                       
            "\n"
        );   
    }      
    
    public static int scannerIntNotRegistered(String str) {
        
        Scanner input = new Scanner(System.in);
        int num = -1;
        
        do {
            System.out.print(str);
            if (input.hasNextInt()) {
                num = input.nextInt();
            } 
            else {
                input.next();
            }
        } while (num < 0 || num > 1);

        return num;
        
    }
    
    public static int scannerInt(String str) {
        
        Scanner input = new Scanner(System.in);
        int num = -1;
        
        do {
            System.out.print(str);
            if (input.hasNextInt()) {
                num = input.nextInt();
            } 
            else {
                input.next();
            }
        } while (num <= 0);

        return num;
        
    }      
    
}