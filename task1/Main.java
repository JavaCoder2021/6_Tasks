/*
 * ������� 1: ������� ���������� ���������� ����� ���� � �������� ����������. 
 * ����� ���������� � �������: 
 * �  ������� ��������� ����� ��� � �����������, ��� � � �������� ��������. 
 * �  ������������ ����: ������������, �������������. 
 * �  ������������ ����� ������������� ����� � �������� ����, ������������ ����� ���� � ��������.  
 * �  ������������� ����� �������������� �������. 
 * �  *��� ���������� �������� ����� � ������� ���������� � ��� ����������� �� e-mail ���� ������������� 
 * �  **��� ��������� �������� ���������� ����������� ������������ �������� 
 * �  ***������������ ����� ���������� �������� ����� � ����������, �������� � �������������� �� e-mail. 
 * �  ������� ���� �������� � ��������� �����. 
 * �  ������ �������������� ������������� �������� � ��������� �����. 
 * ������ �� �������� � �������� ���� 
 */
package by.epam.tasks.task1;

import java.util.Scanner;
import by.epam.tasks.task1.controller.ControllerImpl;

public class Main {
	
	public static void main(String[] args) {

	      	int choice;   
	      	byte userType = 0;
	      	String login="User", password, email;
	      	String[] params;
	      	String response;
	      	ControllerImpl controller = new ControllerImpl();
	        
	        while (true) {
	            if (userType == 1)
	            	System.out.println("\nHello " + login);
	            	menuText();
	            choice = getIntFromConsol("");

	            if (choice < 0 || choice > 3) {
	                System.out.println("Incorrect choose!");
	                continue;
	            }
	             
	            if (choice == 0)
	                break;
	            switch (choice) {
	                case 1:
	                	if (userType == 0) {
		                	login = getStringFromConsol("Login=");
		                	password = getStringFromConsol("Password=");
		                	email = getStringFromConsol("Email=");               	
		                	response = controller.doAction("registration login=" + login + " password=" + password + " email=" + email);
		                	params = response.split("\\s+");
		                	if (params[0].equals("0"))
		                		userType = 1;
		                	else {
		                		userType = 0;
		                		System.out.println(response);
		                	}
	                	} else
	                		System.out.println("You are already registered!");
	                    break;        
	                case 2:
	                	if (userType == 0) {
		                	login = getStringFromConsol("Login=");
		                	password = getStringFromConsol("Password=");
		                	response = controller.doAction("logination login=" + login + " password=" + password);
		                	params = response.split("\\s+");
		                	if (params[0].equals("0"))
		                		userType = 1;
		                	else {
		                		userType = 0;	    
		                		System.out.println(response);
		                	}
	                	} else
	                		System.out.println("You are already registered!");
	                    break;     
	                case 3:
	                	if (userType == 1) {
	                		response = controller.doAction("view_library");
	                		System.out.println(response);
	                	}
	                	else
	                		System.out.println("You not registered!");
	            }     
	            
	        }        

	}
	
	public static void menuText() { 
        System.out.print(
	            "Select the menu item:\n" +
	            "0. Exit\n" +
	            "1. Registration\n" +    
	            "2. Logination\n" +  
	            "3. View book list\n" +  
	            "\n"
	    );   
	}
	
	public static String getStringFromConsol(String str) {

		String a;

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.print(str);
		while (!scanner.hasNextLine()) {
			scanner.nextLine();
			System.out.print(str);
		}
		a = scanner.nextLine();

		return a;

	}
	
	public static int getIntFromConsol(String str) {

		int a;

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.print(str);
		while (!scanner.hasNextInt()) {
			scanner.nextLine();
			System.out.print(str);
		}
		a = scanner.nextInt();

		return a;

	}

}