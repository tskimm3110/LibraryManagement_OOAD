package service.implementation;

import lombok.Data;
import model.*;
import service.ReturnService;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
public class ReturnServiceImpl implements ReturnService {
    @Override
    public Return returnBook(Member member, List<BookCopy> books) {
        for (BookCopy bc : books) {
            if (!bc.isBorrow()) {
                System.out.println(
                        "Book: " + bc.getBook().getTitle() +
                                " | Copy: " + bc.getCopyId() +
                                " was not borrowed!"
                );
                return null;
            }
        }
        for (BookCopy bc : books) {
            bc.setBorrow(false);
        }

        Date returnDate = new Date();
        Date dueDate = null;
        if (!member.getHistories().isEmpty()) {
            History lastHistory = member.getHistories().get(member.getHistories().size() - 1);
            for (Transaction t : lastHistory.getTransactions()) {
                if (t instanceof Borrow) {
                    dueDate = ((Borrow) t).getDueDate();
                }
            }
        }
        Return returnTransaction = new Return();
        returnTransaction.setReturnId(member.getHistories().size() + 1);
        returnTransaction.setBooks(books);
        returnTransaction.setMember(member);
        returnTransaction.setReturnDate(returnDate);
        returnTransaction.setDueDate(dueDate);

        History history = new History();
        history.setHistoryId(member.getHistories().size() + 1);
        history.setMember(member);
        history.setDate(new Date());
        history.setTransactions(new HashSet<>());
        history.getTransactions().add(returnTransaction);

        member.getHistories().add(history);

        System.out.println("Return transaction created and added to history!");

        return returnTransaction;
    }

    @Override
    public Fine calculateFine(Return returnTransaction) {

        if (returnTransaction.getDueDate() == null) {
            System.out.println("No due date found. Cannot calculate fine.");
            return null;
        }

        Date now = new Date();
        long diffMillis = now.getTime() - returnTransaction.getDueDate().getTime();
        long diffDays = diffMillis / (1000 * 60 * 60 * 24);

        if (diffDays <= 0) {
            System.out.println("No fine. Returned on time.");
            return null;
        }

        double amount = diffDays * 2.0;

        Fine fine = new Fine();
        fine.setFineId(returnTransaction.getReturnId());
        fine.setPaid(amount);
        fine.setReason("Late return by " + diffDays + " days");
        fine.setIssueDate(new Date());
        fine.setReturnTransaction(returnTransaction);

        returnTransaction.setFine(fine);

        System.out.println("Fine calculated: $" + amount);

        return fine;
    }
}
