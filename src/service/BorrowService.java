package service;

import lombok.Data;
import model.BookCopy;
import model.Borrow;
import model.Member;

import java.util.Set;
public interface BorrowService {
    public Borrow borrowBook(Member member, Set<BookCopy> books);
}
