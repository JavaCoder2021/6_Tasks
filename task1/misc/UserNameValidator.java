package by.epam.tasks.task1.misc;

import java.util.*;

import by.epam.tasks.task1.bean.User;

public class UserNameValidator {
	
    public static boolean validate(Set<User> users, String userName) {
        
        boolean validateUserName = true;
        
        for (User user : users)
            if (user.getLogin().equals(userName)) {
                validateUserName = false;
                break;
            }
        
        return validateUserName;
      
    }

}