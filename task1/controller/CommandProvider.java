package by.epam.tasks.task1.controller;

import java.util.*;
import by.epam.tasks.task1.controller.impl.LoginationCommand;
import by.epam.tasks.task1.controller.impl.RegistrationCommand;
import by.epam.tasks.task1.controller.impl.ViewLibraryCommand;

public class CommandProvider {

	private Map<String, Command> commands = new HashMap<>();

	public CommandProvider() {
		super();
		commands.put("logination", new LoginationCommand());
		commands.put("registration", new RegistrationCommand());
		commands.put("view_library", new ViewLibraryCommand());
	}

	public Command getCommand(String commandName) {
		Command command;
		command = commands.get(commandName);
		return command;
	}

}
