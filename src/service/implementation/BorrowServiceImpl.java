package service.implementation;

import lombok.Data;
import model.BookCopy;
import model.Borrow;
import model.Member;
import service.BorrowService;

import java.util.Set;
@Data
public class BorrowServiceImpl implements BorrowService {
    @Override
    public Borrow borrowBook(Member member, Set<BookCopy> books) {
        return null;
    }
}
