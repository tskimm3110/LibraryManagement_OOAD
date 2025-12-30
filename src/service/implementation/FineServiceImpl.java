package service.implementation;

import lombok.Data;
import model.Fine;
import model.Payment;
import model.Return;
import service.FineService;
@Data
public class FineServiceImpl implements FineService {
    @Override
    public void createFine(Return returnTransaction) {

    }

    @Override
    public double calculateFine(Return returnTransaction) {
        return 0;
    }

    @Override
    public void payFine(Fine fine, Payment payment) {

    }
}
