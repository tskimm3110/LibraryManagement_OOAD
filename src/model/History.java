package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"member"})

public class History {
    private int historyId;
    private User member;
    private Set<Transaction> transactions = new HashSet<>();
    private Date date;

//    public History(int historyId, User member, Date date) {
//        this.member = member;
//        this.historyId = historyId;
//        this.date = date;
//        this.transactions = new HashSet<>();
//    }
}
