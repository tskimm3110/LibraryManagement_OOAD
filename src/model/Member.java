package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Member extends User{
    private List<History> histories = new ArrayList<>();
    private Date joinedDate;
    private int currentLoanCount;
    private int maxLoanLimit;

    public Member(int userId, String userName, String password,String phoneNumber, String address ,Date joinedDate, int maxLoanLimit) {
        super(userId,userName,password,phoneNumber,address);
        this.joinedDate = joinedDate;
        this.maxLoanLimit = maxLoanLimit;
        this.currentLoanCount = 0;
        this.histories = new ArrayList<>();
    }
}
