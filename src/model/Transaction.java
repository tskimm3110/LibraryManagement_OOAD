package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private int transactionId;
    private List<BookCopy> books = new ArrayList<>();
    private Librarian handleBy;
    private Date createdAt;
    private Member member;
}
