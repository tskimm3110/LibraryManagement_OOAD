package service;

import model.BookCopy;
import model.Member;
import model.Reservation;

import java.util.Set;

public interface ReservationService {
    public Reservation reserseBook(Member member, Set<BookCopy> books);
    public void cancelReserse(Reservation reservation);
    public void fullReserve(Reservation reservation);
}
