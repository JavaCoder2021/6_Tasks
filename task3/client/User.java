package by.epam.tasks.task3.client;

public class User {
    
    private int userType;
    private final String login;
    private final String passwordHash;
    private String email;
    
    public User() {
	this.userType = -1;
        this.login = "";
	this.passwordHash = "";
	this.email = "";
    }
    
    public User(int userType, String login, String passwordHash, String email) {
        this.userType     = userType;
        this.login        = login;
        this.passwordHash = passwordHash;
        this.email        = email;
    }
    
    public int getUserType() {
        return userType;
    }
    
    public String getLogin() {
        return login;
    }    
    
    public String getPassword() {
        return passwordHash;
    }     
    
    public String getEmail() {
        return email;
    }    
    
    public void setUserType(int userType) {
        this.userType = userType;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return  userType + ":" + login + ":" + passwordHash + ":" + email;
    }   
    
}