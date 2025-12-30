package service;

import model.*;

import java.util.Set;

public interface ReturnService {
    public Return returnBook(Member member, Set<BookCopy> books);
    public Fine calculateFine(Return returnTransaction);
}
