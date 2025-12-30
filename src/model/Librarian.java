package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Librarian extends User{
    private int librarianId;
    private String shift;
    private Date hireDate;
    public Librarian(int librarianId, String shift, Date hireDate, int userId, String userName, String password, String phoneNumber,String address){
        super(userId,userName,password,phoneNumber,address);
        this.librarianId = librarianId;
        this.shift = shift;
        this.hireDate = hireDate;
    }
}
