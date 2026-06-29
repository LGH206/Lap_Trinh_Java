package com.fe.horseracing.repository.interfaces;

import java.util.List;
import com.fe.horseracing.pojo.Notification;

public interface INotificationRepository {

    // CREATE
    void save(Notification notification);

    // UPDATE
    void update(Notification notification);

    // DELETE
    void delete(Long notificationId);

    // READ
    Notification findById(Long notificationId);

    List<Notification> findAll();

    // QUERY
    List<Notification> findByUser(Long userId);

    List<Notification> findUnreadByUser(Long userId);

    List<Notification> findReadByUser(Long userId);

    Long countUnread(Long userId);

    Notification markAsRead(Long notificationId);
}