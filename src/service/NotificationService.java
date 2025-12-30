package service;

import model.Member;
import model.NotificationType;

public interface NotificationService {
    public void sentNotification(Member member, String message , NotificationType type);
}
