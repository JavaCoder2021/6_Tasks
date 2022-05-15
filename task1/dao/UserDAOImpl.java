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

		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/by/epam/tasks/task1/source/users.dat"))) {
			users = (HashSet<User>) objectInputStream.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("File users.dat not found");
		} catch (IOException | ClassNotFoundException e) {
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

		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/by/epam/tasks/task1/source/users.dat"))) {
			users.add(newUser);
			objectOutputStream.writeObject(users);
		} catch (FileNotFoundException e) {
			System.out.println("File users.dat not found");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
