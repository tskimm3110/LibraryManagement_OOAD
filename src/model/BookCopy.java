package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCopy {
    private int copyId;
    private int bookId;
    private boolean isBorrow;
    private Book book;
}
