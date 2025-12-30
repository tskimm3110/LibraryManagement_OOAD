package service;

import model.Book;
import model.BookCopy;
import model.Category;

import java.util.Set;

public interface SearchBookService {
    Set<Book> searchBookByAuthor(String author);
    Set<Book> searchBookById(int id);
    Set<Book> searchBooKByTitle(String title);
    Set<BookCopy> searchAvailableCopies(Book book);
    Set<Book> searchBookByCategory(Category category);
}
