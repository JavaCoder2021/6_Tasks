package by.epam.tasks.task3.server;

import java.io.Serializable;

public class Student implements Serializable {  
    private static final long serialVersionUID = 1L;    
    private int    id;
    private String name;
    private int    age;
    private String adress;
    private int    groupNumber;
    
    private static int ID = 0;
    
    public Student() {
        this.id = 0;
        this.name = "";
        this.age = 0;
        this.adress = "";
        this.groupNumber = 0;
    }
    
    public Student(String name, int age, String adress, int groupNumber) {
        this.id          = ++ID;
	this.name        = name;
        this.age         = age;
	this.adress      = adress;
	this.groupNumber = groupNumber;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getAdress() {
        return adress;
    }   
    
    public int getGroupNumber() {
        return groupNumber;
    }
    
    public void setName(String name) {
        this.name = name;
    } 
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setAdress(String adress) {
        this.adress = adress;
    } 
    
    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }
    
    @Override
    public String toString() {
	return  "\n" +
                "Id: " + id + "\n" +
                "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Adress: " + adress + "\n" +
                "Group number: " + groupNumber + "\n";
    } 
    
}