package service.implementation;

import lombok.Data;
import model.*;
import service.BorrowService;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
public class BorrowServiceImpl implements BorrowService {
    @Override
    public Borrow borrowBook( Member member, Librarian librarian,   List<BookCopy> books) {
        System.out.println();
        boolean isBookIsNotAvai = false;
        for (BookCopy bookCopy : books) {
            if (bookCopy.isBorrow()) {
                System.out.println(
                        "Book : " + bookCopy.getBook().getTitle() +
                                " | Copy : " + bookCopy.getCopyId() +
                                " is NOT available!"
                );
                return null;
            }
        }
        for (BookCopy bookCopy : books) {
            bookCopy.setBorrow(true);
        }
        Date createdAt = new Date();
        Date dueDate = new Date(
                createdAt.getTime() + (7L * 24 * 60 * 60 * 1000)
        );

        Borrow borrow = new Borrow(
                member.getCurrentLoanCount() + 1,
                books,
                librarian,
                createdAt,
                dueDate,
                member
        );
        member.setCurrentLoanCount(
                borrow.getMember().getCurrentLoanCount() + 1
        );

        History history = new History();
        history.setHistoryId(member.getHistories().size() + 1);
        history.setMember(member);
        history.setDate(new Date());
        history.setTransactions(new HashSet<>());
        history.getTransactions().add(borrow);
        member.getHistories().add(history);

        System.out.println("Borrow created successfully!");
        return borrow;
    }
}
