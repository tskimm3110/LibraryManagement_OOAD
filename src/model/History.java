package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"member", "transactions"}) // exclude circular refs

public class History {
    private int historyId;
    private User member;
    private List<Transaction> transactions = new ArrayList<>();
    private Date date;

//    public History(int historyId, User member, Date date) {
//        this.member = member;
//        this.historyId = historyId;
//        this.date = date;
//        this.transactions = new HashSet<>();
//    }
}
