package service.implementation;

import lombok.Data;
import model.BookCopy;
import model.Fine;
import model.Member;
import model.Return;
import service.ReturnService;

import java.util.Set;
@Data
public class ReturnServiceImpl implements ReturnService {
    @Override
    public Return returnBook(Member member, Set<BookCopy> books) {
        return null;
    }

    @Override
    public Fine calculateFine(Return returnTransaction) {
        return null;
    }
}
