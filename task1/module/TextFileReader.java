package by.epam.tasks.task1.module;

//import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

public class TextFileReader {
    
    public static LinkedList<User> readUsersFile() {
        
        LinkedList<User> users = new LinkedList();
        String lineRead;
        String[] splitLine;
        User user;
        
        try (BufferedReader reader = new BufferedReader(new FileReader("users.csv"))) {
            
            lineRead = reader.readLine();
            while (lineRead != null) {
                splitLine = lineRead.split(":");
                lineRead = reader.readLine();
                user = new User(Integer.parseInt(splitLine[0]), splitLine[1], splitLine[2], splitLine[3]); 
                users.add(user);
            }
        }    
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        return users;
        
    }
    
    public static void appendUsersFile(String user) {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.csv", true))) {
            writer.write(user);
            writer.newLine();
        }
        catch ( IOException e ) {
            System.out.println(e.getMessage());
        } 
        
    }  
    
    public static LinkedList<Book> readBooksFile() {
        
        LinkedList<Book> books = new LinkedList();
        String lineRead;
        String[] splitLine;
        Book book = null;
        
        try (BufferedReader reader = new BufferedReader(new FileReader("books.csv"))) {
            
            lineRead = reader.readLine();
            while (lineRead != null) {
                splitLine = lineRead.split(":");
                //System.out.println(lineRead);
                lineRead = reader.readLine();
                if (splitLine.length == 4)
                    book = new Book(splitLine[0], splitLine[1], splitLine[2], Integer.parseInt(splitLine[3])); 
                else if (splitLine.length == 5)
                    book = new EBook(splitLine[0], splitLine[1], splitLine[2], Integer.parseInt(splitLine[3]), splitLine[4]);
                books.add(book);
            }
        }    
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        return books;
        
    }
    
    public static void appendBooksFile(String book) {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.csv", true))) {
            writer.write(book);
            writer.newLine();
        }
        catch ( IOException e ) {
            System.out.println(e.getMessage());
        } 
        
    }   
    
    public static void overwriteBooksFile(LinkedList<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.csv", false))) {   
            String str;
            for (Book book : books) {
                str = book.toString();
                writer.write(str);
                writer.newLine();                
            }
            writer.close();
        }
        catch ( IOException e ) {
            System.out.println(e.getMessage());
        } 
        
    }
    
}
