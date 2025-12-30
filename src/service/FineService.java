package service;

import model.Fine;
import model.Payment;
import model.Return;

public interface FineService {
    public void createFine(Return returnTransaction);
    public double calculateFine(Payment returnTransaction);
    public void payFine(Fine fine, Payment payment);
}
