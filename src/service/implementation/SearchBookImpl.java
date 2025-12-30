package service.implementation;

import lombok.Data;
import model.Book;
import model.BookCopy;
import model.Category;
import service.SearchBookService;

import java.util.Set;
@Data
public class SearchBookImpl implements SearchBookService {

    @Override
    public Set<Book> searchBookByAuthor(String author) {
        return Set.of();
    }

    @Override
    public Set<Book> searchBookById(int id) {
        return Set.of();
    }

    @Override
    public Set<Book> searchBooKByTitle(String title) {
        return Set.of();
    }

    @Override
    public Set<BookCopy> searchAvailableCopies(Book book) {
        return Set.of();
    }

    @Override
    public Set<Book> searchBookByCategory(Category category) {
        return Set.of();
    }
}
