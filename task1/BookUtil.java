package by.epam.tasks.task1;

import by.epam.tasks.task1.module.Book;
import java.util.LinkedList;

public class BookUtil {
    
    public static void booksPrint(LinkedList<Book> books) {
        
        for (Book book : books)
            System.out.println(book.print());
        
    }
    
    public static LinkedList<Book> booksOnPages(LinkedList<Book> books, int booksOnPage, int nowPage) {
        
        LinkedList<Book> filteredBooks = new LinkedList();
        
            int totalBooks = books.size();
            int totalPages = totalBooks % booksOnPage == 0 ? totalBooks / booksOnPage : totalBooks / booksOnPage + 1;
            if (nowPage > totalPages)
                nowPage = 1;
            int end = (nowPage == totalPages) ? books.size() : ((nowPage - 1) * booksOnPage + booksOnPage);
            if (nowPage <= totalPages) {
                for (int i = (nowPage - 1) * booksOnPage; i < end; i++)
                    filteredBooks.add(books.get(i));
            }
                        
        return (filteredBooks.size() > 0 ? filteredBooks : null);                        
        
    }    
    
    public static Book findBookById(LinkedList<Book> books, int id) {
        
        Book nowBook = null;
        
        for (Book book : books) {
            
            if (book.getId() == id) {
                nowBook = book;
                break;
            }
            
        }
        
        return nowBook;
        
    }

    public static LinkedList<Book> filterByTitle(LinkedList<Book> books, String title) {

        LinkedList<Book> filteredBooks = new LinkedList();

        for (Book book : books)
            if (book.getTitle().toLowerCase().equals(title.toLowerCase()))
                filteredBooks.add(book);

        return (filteredBooks.size() > 0 ? filteredBooks : null);
        
    }

    public static LinkedList<Book> filterByAuthor(LinkedList<Book> books, String author) {

        LinkedList<Book> filteredBooks = new LinkedList<>();

        for (Book book : books)
            if (book.getAuthor().toLowerCase().equals(author.toLowerCase()))
                filteredBooks.add(book);
 

        return (filteredBooks.size() > 0 ? filteredBooks : null);
        
    }

    public static LinkedList<Book> filterByPublisher(LinkedList<Book> books, String publisher) {

        LinkedList<Book> filteredBooks = new LinkedList<>();

        for (Book book : books)
            if (book.getPublisher().toLowerCase().equals(publisher.toLowerCase()))
                filteredBooks.add(book);

        return (filteredBooks.size() > 0 ? filteredBooks : null);
        
    }

    public static LinkedList<Book> filterByYear(LinkedList<Book> books, int filterStart, int filterFinish) {

        LinkedList<Book> filteredBooks = new LinkedList<>();

        for (Book book : books)
            if (filterStart <= book.getYear() && book.getYear() <= filterFinish)
                filteredBooks.add(book);

        return (filteredBooks.size() > 0 ? filteredBooks : null);
        
    }

    public static void deleteBook(LinkedList<Book> books, int id) {
        
        Book book = findBookById(books, id);
               
        if (book == null)
            System.out.println("Error: book is not found");
        else if (books.remove(book))
            System.out.println("Successful");
        
    }    
    
}
