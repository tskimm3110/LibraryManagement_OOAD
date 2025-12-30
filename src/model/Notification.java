package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    private int notificationId;
    private String message;
    private NotificationType Type;
    private Date sentDate;
    private Member receiver;
}
