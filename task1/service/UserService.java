package by.epam.tasks.task1.service;

import java.util.Set;
import by.epam.tasks.task1.bean.User;

public interface UserService {
	
	Set<User> readUsers();
	
	void saveUser(User newUser);

	boolean logination(String login, String password);

}