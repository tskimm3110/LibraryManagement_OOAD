package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fine {
    private int fineId;
    private Double paid;
    private String reason;
    private Date issueDate;
    private Payment payment;
    private Return returnTransaction;

}
