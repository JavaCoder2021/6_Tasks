package by.epam.tasks.task1;

import by.epam.tasks.task1.module.User;
import by.epam.tasks.task1.module.TextFileReader;
import by.epam.tasks.task1.module.EBook;
import by.epam.tasks.task1.module.Book;
import by.epam.tasks.task1.misc.UserNameValidator;
import by.epam.tasks.task1.misc.EmailValidator;
import by.epam.tasks.task1.misc.Hesh;
import java.util.Scanner;
import java.util.LinkedList;

public class Menu {
    
    public static void Show() {
        
        LinkedList<User> users = TextFileReader.readUsersFile();
        LinkedList<Book> books = TextFileReader.readBooksFile();        
        LinkedList<Book> booksNow;
        User user;  
        Book book;  
        int USER_TYPE = -1;
        String login = "user";
        String password;       
        int choice = 0, count;
        String usersEmailToString;
        Scanner input = new Scanner(System.in);
        String passwordHash;        
        
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
                
                if (choice == 0)
                    break;
                if (choice < 0 || choice > 2) 
                {
                    System.out.println("Incorrect choose!");
                    continue;
                }
                
                input.nextLine();
                      
                switch (choice)
                {
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
                
                if (choice == 0)
                    break;
                if (choice < 0 || choice > 7) 
                {
                    System.out.println("Incorrect choose!");
                    continue;
                }
                
                input.nextLine();   
                
                switch (choice)
                {
                    case 1: 
                        booksNow = BookUtil.booksOnPages(books, 10, MenuUtil.scannerInt("Page: "));
                        BookUtil.booksPrint(booksNow);
                        break;
                    case 2: 
                        book = BookUtil.findBookById(books, MenuUtil.scannerInt("Id: ")); 
                        System.out.println(book == null ? "Book is not found" : book.print());
                        break;  
                    case 3: 
                        System.out.print("Title: ");                     
                        booksNow = BookUtil.filterByTitle(books, input.nextLine());
                        if (booksNow == null)
                            System.out.println("Books are not found");
                        else
                            BookUtil.booksPrint(booksNow);
                        break;  
                    case 4: 
                        System.out.print("Author: ");                     
                        booksNow = BookUtil.filterByAuthor(books, input.nextLine());
                        if (booksNow == null)
                            System.out.println("Books are not found");
                        else
                            BookUtil.booksPrint(booksNow);
                        break;  
                    case 5: 
                        System.out.print("Publisher: ");                     
                        booksNow = BookUtil.filterByPublisher(books, input.nextLine());
                        if (booksNow == null)
                            System.out.println("Books are not found");
                        else
                            BookUtil.booksPrint(booksNow);
                        break;  
                    case 6:                    
                        booksNow = BookUtil.filterByYear(books, MenuUtil.scannerInt("Start year: "), MenuUtil.scannerInt("Finish year: "));
                        if (booksNow == null)
                            System.out.println("Books are not found");
                        else
                            BookUtil.booksPrint(booksNow);
                        break;   
                    case 7: 
                        //----------Input data--------------- 
                        System.out.println("Suggest a book:");                        
                        
                        System.out.print("Input Title: "); 
                        String title = input.nextLine();  
                    
                        System.out.print("Input Author: "); 
                        String author = input.nextLine();  
                    
                        System.out.print("Input Publisher: "); 
                        String publisher = input.nextLine();
                    
                        int year = MenuUtil.scannerInt("Input Year: ");
                    
                        System.out.print("Input Location [null or path]: "); 
                        String location = input.nextLine();                   
                        //----------Create book-----------------
                        if (location.equals("null"))
                            book = new Book(title, author, publisher, year);
                        else
                            book = new EBook(title, author, publisher, year, location);                  
                        //----------Send e-mail-----------------
                        count = 0;    
                        usersEmailToString = "";
                        for (User userNow : users) {
                            if (userNow.getUserType() == 1) {   
                                count++;
                                if (count > 1)
                                    usersEmailToString += "," + userNow.getEmail();
                                else
                                    usersEmailToString += userNow.getEmail();
                            }                                
                        }
                        //Email.Send(usersEmailToString, book.print());
                        System.out.println("Send to: " + usersEmailToString);                        
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
                
                if (choice == 0)
                    break;
                if (choice < 0 || choice > 8) 
                {
                    System.out.println("Incorrect choose!");
                    continue;
                }
                
                input.nextLine();  
                
                switch (choice)
                {
                    case 1: 
                        booksNow = BookUtil.booksOnPages(books, 10, MenuUtil.scannerInt("Page: "));
                        BookUtil.booksPrint(booksNow);
                        break;
                    case 2: 
                        book = BookUtil.findBookById(books, MenuUtil.scannerInt("Id: ")); 
                        System.out.println(book == null ? "Book is not found" : book.print());
                        break;  
                    case 3: 
                        System.out.print("Title: ");                     
                        booksNow = BookUtil.filterByTitle(books, input.nextLine());
                        if (booksNow == null)
                            System.out.println("Books are not found");
                        else
                            BookUtil.booksPrint(booksNow);
                        break;  
                    case 4: 
                        System.out.print("Author: ");                     
                        booksNow = BookUtil.filterByAuthor(books, input.nextLine());
                        if (booksNow == null)
                            System.out.println("Books are not found");
                        else
                            BookUtil.booksPrint(booksNow);
                        break;  
                    case 5: 
                        System.out.print("Publisher: ");                     
                        booksNow = BookUtil.filterByPublisher(books, input.nextLine());
                        if (booksNow == null)
                            System.out.println("Books are not found");
                        else
                            BookUtil.booksPrint(booksNow);
                        break;  
                    case 6:                    
                        booksNow = BookUtil.filterByYear(books, MenuUtil.scannerInt("Start year: "), MenuUtil.scannerInt("Finish year: "));
                        if (booksNow == null)
                            System.out.println("Books are not found");
                        else
                            BookUtil.booksPrint(booksNow);
                        break;                         
                    case 7:                         
                        //----------Input data--------------- 
                        System.out.println("Add book:");                        
                        
                        System.out.print("Input Title: "); 
                        String title = input.nextLine();  
                    
                        System.out.print("Input Author: "); 
                        String author = input.nextLine();  
                    
                        System.out.print("Input Publisher: "); 
                        String publisher = input.nextLine();
                    
                        int year = MenuUtil.scannerInt("Input Year: ");
                    
                        System.out.print("Input Location [null or path]: "); 
                        String location = input.nextLine();                   
                        //----------Create book-----------------
                        if (location.equals("null"))
                            book = new Book(title, author, publisher, year);
                        else
                            book = new EBook(title, author, publisher, year, location);
                        books.add(book);                   
                        TextFileReader.appendBooksFile(book.toString());
                        //----------Send e-mail-----------------
                        count = 0;    
                        usersEmailToString = "";
                        for (User userNow : users) {
                            count++;
                            if (count > 1)
                                usersEmailToString += "," + userNow.getEmail();
                            else
                                usersEmailToString += userNow.getEmail();
                                
                        }
                        //Email.Send(usersEmailToString, book.print());
                        System.out.println("Send to: " + usersEmailToString);
                        break;
                    case 8:  
                        //----------Input data--------------- 
                        System.out.println("Delete book:");                       
                        BookUtil.deleteBook(books, MenuUtil.scannerInt("Id: "));
                        TextFileReader.overwriteBooksFile(books);
                        break;
                }
                
            }            
            
        }        
        
    }
    
}
