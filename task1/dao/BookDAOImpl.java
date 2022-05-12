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

		try {
			FileInputStream freader = new FileInputStream("src/by/epam/tasks/task1/source/books.dat");
			ObjectInputStream objectInputStream = new ObjectInputStream(freader);
			books = (HashSet<Book>) objectInputStream.readObject();
			freader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File books.dat not found");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return books;

	}

	@Override
	public void writeBook(Book newBook) {

		try {
			books.add(newBook);
			FileOutputStream outStream = new FileOutputStream("src/by/epam/tasks/task1/source/books.dat");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream);
			objectOutputStream.writeObject(books);
			outStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
