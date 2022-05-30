package ru.iroqquois.wsnotification.service;

import ru.iroqquois.wsnotification.entity.Notification;
import ru.iroqquois.wsnotification.payload.request.NotificationCreateRequest;
import ru.iroqquois.wsnotification.payload.request.NotificationUpdateRequest;
import ru.iroqquois.wsnotification.payload.response.MessageResponse;

import java.util.List;

public interface NotificationService {
    List<Notification> getList();
    
    Notification get(Long id);

    Notification create(NotificationCreateRequest request);

    Notification update(Long id, NotificationUpdateRequest request);

    void delete(Long id);

    MessageResponse send(Long id);
}
