package by.epam.tasks.task1.dao;

import java.util.*;
import by.epam.tasks.task1.bean.Book;

public interface BookDAO {

	Set<Book> readBooks();

	void writeBook(Book newBook);

}
