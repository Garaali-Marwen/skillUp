package com.Projet.Projet.Services;

import com.Projet.Projet.Entities.CentreFormation;
import com.Projet.Projet.Entities.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> getAllNotifications();

    Notification getNotificationById(Long id);

    Notification addNotification(Notification notification);

    Notification editNotification(Long id, Notification notification);

    void deleteNotification(Long id);
    Notification addNotificationToCentreFormation(Long nId,Long cId);
    Notification addNotificationToClient(Long nId,Long cId);
}
