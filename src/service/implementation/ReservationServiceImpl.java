package service.implementation;

import lombok.Data;
import model.*;
import service.ReservationService;

import java.util.Date;
import java.util.Set;
@Data
public class ReservationServiceImpl implements ReservationService {
    @Override
    public Reservation reserveBook(Member member, BookCopy bookCopy, Librarian librarian) {
        Reservation reservation = new Reservation();
        reservation.setTransactionId(member.getHistories().size() + 1);
        reservation.setReservationId(member.getHistories().size() + 1);
        reservation.setMember(member);
        reservation.setBookCopy(bookCopy);
        reservation.setReservationDate(new Date());
        reservation.setStatus("PENDING");
        reservation.setHandleBy(librarian);
        System.out.println("Reservation created for " + bookCopy.getBook().getTitle() +
                " by " + member.getUserName());

        History history = new History();
        history.setHistoryId(member.getHistories().size()+1);
        history.setMember(member);
        history.setDate(new Date());
        history.getTransactions().add(reservation);
//        System.out.println(history);
        member.getHistories().add(history);
        return reservation;
    }

    @Override
    public void cancelReserve(Reservation reservation) {
        reservation.setStatus("CANCELLED");
        System.out.println("Reservation cancelled for book: " +
                reservation.getBookCopy().getBook().getTitle());
    }

    @Override
    public void fulfillReserve(Reservation reservation) {
        reservation.setStatus("FULFILLED");
        System.out.println("Reservation fulfilled for book: " +
                reservation.getBookCopy().getBook().getTitle());
    }
}
