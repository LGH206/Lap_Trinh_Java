package com.fe.horseracing.service.interfaces;

import java.util.List;
import com.fe.horseracing.pojo.Notification;
import com.fe.horseracing.pojo.User;

public interface INotificationService {
	
    void save(Notification notification);

    void update(Notification notification);

    void delete(Long notificationId);

    Notification findById(Long notificationId);

    List<Notification> findAll();

    List<Notification> findByUser(Long userId);

    List<Notification> findUnreadByUser(Long userId);

    List<Notification> findReadByUser(Long userId);

    Long countUnread(Long userId);
    
    void sendNotification(User user, String title, String message);

    Notification markAsRead(Long notificationId);

    void markAllAsRead(Long userId);

}
