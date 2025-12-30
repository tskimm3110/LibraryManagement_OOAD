package service.implementation;

import lombok.Data;
import model.BookCopy;
import model.Member;
import model.Reservation;
import service.ReservationService;

import java.util.Set;
@Data
public class ReservationServiceImpl implements ReservationService {
    @Override
    public Reservation reserseBook(Member member, Set<BookCopy> books) {
        return null;
    }

    @Override
    public void cancelReserse(Reservation reservation) {

    }

    @Override
    public void fullReserve(Reservation reservation) {

    }
}
