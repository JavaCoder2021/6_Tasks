package by.epam.tasks.task1.service;

import java.util.Set;
import by.epam.tasks.task1.bean.Book;

public interface BookService {

	Set<Book> readBooks();

	void saveBook(Book newBook);

}
