package com.Projet.Projet.Services.ServicesImplementation;

import com.Projet.Projet.Entities.CentreFormation;
import com.Projet.Projet.Entities.Client;
import com.Projet.Projet.Entities.Notification;
import com.Projet.Projet.Repositories.CentreFormationRepository;
import com.Projet.Projet.Repositories.NotificationRepository;
import com.Projet.Projet.Services.CentreFormationService;
import com.Projet.Projet.Services.ClientService;
import com.Projet.Projet.Services.NotificationService;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {


    private NotificationRepository notificationRepository;

    private CentreFormationRepository centreFormationRepository;

    private CentreFormationService centreFormationService;
    private ClientService clientService;

    @Override
    public List<Notification> getAllNotifications(){
        return notificationRepository.findAll();
    }

    @Override
    public Notification getNotificationById(Long id){
        return notificationRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("aucune notification trouvée"));
    }

    @Override
    public Notification addNotification(Notification notification){
        return notificationRepository.save(notification);
    }

    @Override
    public Notification editNotification(Long id, Notification notification){
        Notification notificationDB = getNotificationById(id);

        notificationDB.setContenu(notification.getContenu());
        notificationDB.setEtat(notification.getEtat());
        notificationDB.setDate(notification.getDate());

        notificationRepository.save(notificationDB);

        return notificationDB;
    }

    @Override
    public void deleteNotification(Long id){
        notificationRepository.deleteById(id);
    }

    @Override
    public Notification addNotificationToCentreFormation(Long nId, Long cId) {
        Notification notification=notificationRepository.findById(nId).orElse(null);
        CentreFormation centreFormation=centreFormationRepository.findById(cId).orElse(null);
        if(notification!=null){
            notification.setCentreFormation(centreFormation);
            editNotification(nId,notification);
        }
        if(centreFormation!=null){
            centreFormation.getNotifications().add(notification);
            centreFormationService.updateCentreFormation(centreFormation);
        }
        return notification;
    }

    @Override
    public Notification addNotificationToClient(Long nId, Long cId) {
        Notification notification=notificationRepository.findById(nId).orElse(null);
        Client client=clientService.getClientById(cId);
        if (notification!=null){
            notification.setClient(client);
            editNotification(nId,notification);
        }
        if (client!=null){
            client.getNotifications().add(notification);
            clientService.updateClient(client);
        }
        return notification;
    }

    @Override
    public Notification addNotificationToAdmin(Long nId, Long aId) {

        return null;
    }
}
