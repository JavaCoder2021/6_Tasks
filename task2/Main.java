/*
 * ������� 2. �������.  ����������� ���������� ����������, ���������� � ��������� 
 * � ��������. ������ ������� ���: ������� (����, ���� ��������, e-mail, ���������).  
 *  
 *  ����� ��������� � ������������� �������. 
 *  �  � ������ ������ ���������� ������ ������ ����������� �� �����,  � ����� 
 *  ������ � ����������� � ����. 
 *  �  � ������������ ������ ���� ����������� ����� ������ �� ������ ��������� 
 *  ���  ��  ������  ����������  (������  ����������  �����  ���������� 
 *  ��������������), ��������  ���������  ������ � ��������������� ����, ����� 
 *  ������,  ���������  ����  �������  ��������  ������������  �����,  �  ����� 
 *  �������� ����� ������. 
 *  �  ������  �������:  �����,  ���������  �  ���������  ��������  ���������� 
 *  ������������ � �������������� ���������� ���������. 
 *  �  ������  �������:  ��������  ���������  ����������  ��  ����������  ������ 
 *  ������������ ���, ��������������� ����������� ����������.
 */
package by.epam.tasks.task2;

import java.util.*;

public class Main {
    
    public static void main(String[] args) { 
        
        int choice;
        LinkedList<Note> notebooks = FileManager.readFile();
        
        /** Menu */         
        while (true) {
            menuText();
            choice = scannerInt("");
            if (choice == 0) {
                FileManager.writeFile(notebooks);          
                break;
            }
            if (choice < 1 || choice > 6) {
                System.out.println("Incorrect choose!");
                continue;
            }
                      
            switch (choice) {
                case 1:
                    Notebook.printNotes(notebooks);
                    break;
                case 2:
                    notebooks.add(Notebook.addNote());                    
                    break;
                case 3:
                    Notebook.findByHeader(notebooks);                  
                    break;
                case 4:
                    Notebook.findByDate(notebooks);                  
                    break;
                case 5:
                    Notebook.findByEmail(notebooks);                
                    break;
                case 6:
                    Notebook.findByText(notebooks);                
                    break;
            }     
            
        }
            
    }
    
    /**
     * Text of menu
     */    
    private static void menuText() { 
        System.out.print(
            "\n" + 
            "Select the menu item:\n" +
            "0. Exit\n" +
            "1. Show all notes\n" +  
            "2. Add note\n" +      
            "3. Find by header\n" + 
            "4. Find by date\n" +
            "5. Find by e-mail\n" +
            "6. Find by text\n" +
            "\n"
        );   
    }
    
    /**
     * Scanner value Integer
     */     
    private static int scannerInt(String str) { 
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
        } while (num < 0);
        return num;
    }
    
}