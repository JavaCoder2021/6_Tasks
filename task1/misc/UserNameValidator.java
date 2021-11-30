package by.epam.tasks.task1.misc;

import by.epam.tasks.task1.module.User;
import java.util.LinkedList;

public class UserNameValidator {
    
    public static boolean validate(LinkedList<User> users, String userName) {
        
        boolean validateUserName = true;
        
        for (User user : users)
            if (user.getLogin().equals(userName))
            {
                validateUserName = false;
                break;
            }
        
        return validateUserName;
      
    }
    
}
