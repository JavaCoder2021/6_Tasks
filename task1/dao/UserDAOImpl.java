package by.epam.tasks.task1.dao;

import java.io.*;
import java.util.*;
import by.epam.tasks.task1.bean.User;
import by.epam.tasks.task1.misc.Hesh;

public class UserDAOImpl implements UserDAO {

	private Set<User> users = new HashSet<User>();

	public UserDAOImpl() {
		super();
	}

	public UserDAOImpl(Set<User> users) {
		super();
		this.users = users;
	}

	@Override
	public Set<User> readUsers() {

		try {
			FileInputStream freader = new FileInputStream("src/by/epam/tasks/task1/source/users.dat");
			ObjectInputStream objectInputStream = new ObjectInputStream(freader);
			users = (HashSet<User>) objectInputStream.readObject();
			freader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File users.dat not found");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return users;

	}

	@Override
	public boolean logination(String login, String password) {

		for (User user : users)
			if (user.getLogin().equals(login)) {
				if (user.getPasswordHash().equals(Hesh.getHesh(password))) {
					return true;
				}
				break;
			}

		return false;

	}

	@Override
	public void writeUser(User newUser) {

		try {
			users.add(newUser);
			FileOutputStream outStream = new FileOutputStream("src/by/epam/tasks/task1/source/users.dat");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream);
			objectOutputStream.writeObject(users);
			outStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}