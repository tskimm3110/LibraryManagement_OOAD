package service;

import model.*;

import java.util.List;
import java.util.Set;

public interface ReturnService {
    public Return returnBook(Member member, List<BookCopy> books);
    public Fine calculateFine(Return returnTransaction);
}
