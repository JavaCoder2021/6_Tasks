package by.epam.tasks.task1.controller;

import by.epam.tasks.task1.service.BookService;
import by.epam.tasks.task1.service.ServiceProvider;

public class BookController implements Controller {

	@Override
	public String doAction(String request) {

		String commandName;

		commandName = request.split("\\s+")[0];

		ServiceProvider provider = ServiceProvider.getInstance();
		BookService bookService = provider.getBookService();

		switch (commandName) {
			case "read":
				bookService.readBooks();
				break;
			case "save":
				bookService.saveBook(null);
				break;
		}

		return null;

	}

}
