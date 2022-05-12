package by.epam.tasks.task1.service;

import java.util.Set;
import by.epam.tasks.task1.bean.Book;
import by.epam.tasks.task1.dao.BookDAO;
import by.epam.tasks.task1.dao.DAOProvider;

public class BookServiceImpl implements BookService {

	private final DAOProvider provider = DAOProvider.getInstance();
	private final BookDAO bookDAO = provider.getBookDAO();

	@Override
	public Set<Book> readBooks() {

		return bookDAO.readBooks();

	}

	@Override
	public void saveBook(Book newBook) {

		bookDAO.writeBook(newBook);

	}

}