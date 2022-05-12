package by.epam.tasks.task1.dao;

import java.util.*;
import by.epam.tasks.task1.bean.User;

public interface UserDAO {
	
	Set<User> readUsers();
	
	boolean logination(String login, String password);
	
	void writeUser(User newUser);

}