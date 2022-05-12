package by.epam.tasks.task1.dao;

public final class DAOProvider {

	private static final DAOProvider instance = new DAOProvider();
	private final UserDAO userDAO = new UserDAOImpl();
	private final BookDAO bookDAO = new BookDAOImpl();

	private DAOProvider() {}

	public static DAOProvider getInstance() {
		return instance;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

}