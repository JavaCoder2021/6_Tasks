package by.epam.tasks.task3.client;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
    
    public static LinkedList<Student> readStudentsFile() {
        
        LinkedList<Student> students = new LinkedList();
        Student student;
        File dir = new File("archive/");
        File[] files = dir.listFiles((d, name) -> name.endsWith(".xml"));
        for(int i = 1; i <= files.length; i++) {
            student = XML.ReadXml("archive/" + i + ".xml");
            students.add(student);
        }
        
        return students;
        
    }

}