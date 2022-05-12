package by.epam.tasks.task1.service;

public class ServiceProvider {

	private static final ServiceProvider instance = new ServiceProvider();
	private final BookService bookService = new BookServiceImpl();
	private final UserService userService = new UserServiceImpl();

	private ServiceProvider() {}

	public BookService getBookService() {
		return bookService;
	}

	public UserService getUserService() {
		return userService;
	}

	public static ServiceProvider getInstance() {
		return instance;
	}

}