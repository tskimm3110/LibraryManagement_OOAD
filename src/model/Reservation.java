package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class Reservation extends Transaction{
    private int reservationId;
    private Member member;
    private BookCopy bookCopy;
    private Date reservationDate;
    private String status = "PENDING"; // PENDING, FULFILLED, CANCELLED
}
