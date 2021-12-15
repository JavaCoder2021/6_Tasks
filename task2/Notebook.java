package by.epam.tasks.task2;

import java.util.*;
import java.text.*;

public class Notebook {
    
    public static String getLine(String str) {
        String resStr;
        Scanner input = new Scanner(System.in);
        do {        
            System.out.print(str);
            resStr = input.nextLine();
        }
        while (resStr.isEmpty());
        
        return resStr;
    }
    
    public static void printNotes(LinkedList<Note> notebooks) {
        for (Note notebook : notebooks)
            System.out.println(notebook.print() + "\n");        
    }
    
    public static Note addNote() {
        Note note;
        String topic, email, message;
        Scanner input = new Scanner(System.in);

        topic = getLine("Topic: ");
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        
        do {
            System.out.print("E-mail: ");                        
            email = input.nextLine();
        }
        while (!EmailValidator.validate(email));

        message = getLine("Message: ");
        
        note = new Note(topic, df.format(date), email, message);
        System.out.println("!Note added successfully"); 
        
        return note;
    }
    
    public static void findByHeader(LinkedList<Note> notebooks) {
        String topic = getLine("Topic: ");
        System.out.println();
        
        for (Note nowNote : notebooks)
            if (nowNote.getTopic().toLowerCase().contains(topic.toLowerCase()))
                System.out.println(nowNote.print() + "\n");
    }
    
    public static void findByDate(LinkedList<Note> notebooks) {
        String date = getLine("Date: ");
        System.out.println();
        
        for (Note nowNote : notebooks)
            if (nowNote.getDate().toLowerCase().contains(date.toLowerCase()))
                System.out.println(nowNote.print() + "\n");
    }
    
    
    public static void findByEmail(LinkedList<Note> notebooks) {
        String email = getLine("E-mail: ");
        System.out.println();
        
        for (Note nowNote : notebooks)
            if (nowNote.getEmail().toLowerCase().contains(email.toLowerCase()))
                System.out.println(nowNote.print() + "\n");
    }
    
    public static void findByText(LinkedList<Note> notebooks) {
        String text = getLine("Text of note: ");
        System.out.println();
        
        for (Note nowNote : notebooks)
            if (nowNote.getMessage().toLowerCase().contains(text.toLowerCase()))
                System.out.println(nowNote.print() + "\n");
    }
    
}