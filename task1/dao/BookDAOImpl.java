package by.epam.tasks.task1.dao;

import java.io.*;
import java.util.*;
import by.epam.tasks.task1.bean.Book;

public class BookDAOImpl implements BookDAO {

	private Set<Book> books = new HashSet<Book>();

	public BookDAOImpl() {
		super();
	}

	public BookDAOImpl(Set<Book> books) {
		super();
		this.books = books;
	}

	@Override
	public Set<Book> readBooks() {

		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/by/epam/tasks/task1/source/books.dat"))) {
			books = (HashSet<Book>) objectInputStream.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("File books.dat not found");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return books;

	}

	@Override
	public void writeBook(Book newBook) {

		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/by/epam/tasks/task1/source/books.dat"))) {
			books.add(newBook);
			objectOutputStream.writeObject(books);
		} catch (FileNotFoundException e) {
			System.out.println("File books.dat not found");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
