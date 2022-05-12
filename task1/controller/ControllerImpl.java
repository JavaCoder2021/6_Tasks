package by.epam.tasks.task1.controller;

public class ControllerImpl implements Controller {
	
	private CommandProvider provider = new CommandProvider();
	
	@Override
	public String doAction(String request) {

		String[] params;
		String commandName, response;
		Command currentCommand;
		
		params = request.split("\\s+");
		commandName = params[0];
		currentCommand = provider.getCommand(commandName);
		response = currentCommand.execute(params);

		return response;

	}

}
