package by.epam.tasks.task1.service;

import java.util.Set;
import by.epam.tasks.task1.bean.User;
import by.epam.tasks.task1.dao.DAOProvider;
import by.epam.tasks.task1.dao.UserDAO;

public class UserServiceImpl implements UserService {

	private final DAOProvider provider = DAOProvider.getInstance();
	private final UserDAO userDAO = provider.getUserDAO();

	@Override
	public Set<User> readUsers() {

		return userDAO.readUsers();

	}

	@Override
	public void saveUser(User newUser) {

		userDAO.writeUser(newUser);

	}

	@Override
	public boolean logination(String login, String password) {

		return userDAO.logination(login, password);

	}

}