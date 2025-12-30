package service.implementation;

import lombok.Data;
import model.Fine;
import model.Payment;
import service.PaymentService;
@Data
public class PaymentServiceImpl implements PaymentService {
    @Override
    public boolean isPaid(Fine fine) {
        return false;
    }

    @Override
    public Payment payFine(Fine fine, double amount, String method) {
        return null;
    }
}
