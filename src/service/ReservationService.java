package service;

import model.BookCopy;
import model.Librarian;
import model.Member;
import model.Reservation;

import java.util.Set;

public interface ReservationService {
    public Reservation reserveBook(Member member, BookCopy books, Librarian librarian);
    public void cancelReserve(Reservation reservation);
    public void fulfillReserve(Reservation reservation);
}
