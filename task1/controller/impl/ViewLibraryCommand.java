package by.epam.tasks.task1.controller.impl;

import by.epam.tasks.task1.bean.Book;
import by.epam.tasks.task1.controller.Command;
import by.epam.tasks.task1.presentation.BookActionViewer;
import by.epam.tasks.task1.service.BookService;
import by.epam.tasks.task1.service.ServiceProvider;

public class ViewLibraryCommand  implements Command {

	@Override
	public String execute(String[] params) {

      	String result = ""; 
      	
		ServiceProvider provider = ServiceProvider.getInstance();
		BookService bookService = provider.getBookService();
	
		for (Book book : bookService.readBooks())
			result = result + book + "\n";

		return BookActionViewer.bookViewAnswer(result);

	}

}
