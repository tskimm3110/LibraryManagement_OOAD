package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow extends Transaction{
    private Date dueDate;
    public Borrow(int transactionId, List<BookCopy> books, Librarian handleBy, Date createdAt, Date dueDate, Member member) {
        super(transactionId, books, handleBy, createdAt,member);
        this.dueDate = dueDate;
    }

}
