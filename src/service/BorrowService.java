package service;

import lombok.Data;
import model.BookCopy;
import model.Borrow;
import model.Librarian;
import model.Member;

import java.util.Date;
import java.util.List;
import java.util.Set;
public interface BorrowService {
    public Borrow borrowBook( Member member, Librarian librarian,   List<BookCopy> books);
}
