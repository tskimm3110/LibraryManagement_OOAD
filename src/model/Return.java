package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Return extends Transaction{
    private int returnId;
    private Fine fine;
    private Date returnDate;
    private Date dueDate;
}
