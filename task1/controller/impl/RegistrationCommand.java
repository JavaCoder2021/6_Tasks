package by.epam.tasks.task1.controller.impl;

import by.epam.tasks.task1.bean.User;
import by.epam.tasks.task1.controller.Command;
import by.epam.tasks.task1.misc.EmailValidator;
import by.epam.tasks.task1.misc.Hesh;
import by.epam.tasks.task1.misc.UserNameValidator;
import by.epam.tasks.task1.presentation.UserActionViewer;
import by.epam.tasks.task1.service.ServiceProvider;
import by.epam.tasks.task1.service.UserService;

public class RegistrationCommand  implements Command {

	@Override
	public String execute(String[] params) {

      		boolean result; 
		String login, password, email;
      	
		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();

		login = params[1].split("=")[1];
		password = params[2].split("=")[1];
		email = params[3].split("=")[1];
		
		result = false;
		if (UserNameValidator.validate(userService.readUsers(), login)) {
			if (password.length() >= 4) {
				if (EmailValidator.validate(email)) {
					userService.saveUser(new User(0, login, Hesh.getHesh(password), email));
					result = true;
				}		
			}
		}

		return UserActionViewer.registrationAnswer(result);

	}

}
