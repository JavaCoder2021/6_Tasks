package by.epam.tasks.task2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

public class FileManager {
    
    public static LinkedList<Note> readFile() {  
        LinkedList<Note> notebooks = new LinkedList();
        Note notebook;
        String[] splitLine;
        String lineRead;              
        try (BufferedReader reader = new BufferedReader(new FileReader("notes.csv"))) {  
            lineRead = reader.readLine();
            while (lineRead != null) {
                splitLine = lineRead.split(":");
                lineRead = reader.readLine();
                notebook = new Note(splitLine[0], splitLine[1], splitLine[2], splitLine[3]);
                notebooks.add(notebook);
            }
            reader.close();
        }    
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return notebooks;
    }
    
    public static void writeFile(LinkedList<Note> notebooks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("notes.csv", false))) {   
            for (Note notebook : notebooks)
                writer.write(notebook.toString() + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }   
    }
    
}