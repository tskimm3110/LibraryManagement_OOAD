package service.implementation;

import lombok.Data;
import model.Member;
import model.NotificationType;
import service.NotificationService;
@Data
public class NotificationServiceImpl implements NotificationService {
    @Override
    public void sentNotification(Member member, String message, NotificationType type) {

    }
}
