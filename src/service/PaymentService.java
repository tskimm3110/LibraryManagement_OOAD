package service;

import model.Fine;
import model.Payment;

public interface PaymentService {
    public boolean isPaid(Fine fine);
    public Payment payFine(Fine fine, double amount, String method);
}
