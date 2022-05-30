package ru.iroqquois.wsnotification.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.iroqquois.wsnotification.entity.Notification;
import ru.iroqquois.wsnotification.mapper.NotificationMapper;
import ru.iroqquois.wsnotification.payload.request.NotificationCreateRequest;
import ru.iroqquois.wsnotification.payload.request.NotificationUpdateRequest;
import ru.iroqquois.wsnotification.payload.response.MessageResponse;
import ru.iroqquois.wsnotification.repository.NotificationRepository;
import ru.iroqquois.wsnotification.service.NotificationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    @Override
    public List<Notification> getList() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification get(Long id) {
        return notificationRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public Notification create(NotificationCreateRequest request) {
        Notification notification = Notification.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .lastSentAt(request.getLastSentAt())
                .build();

        notificationRepository.save(notification);

        return notification;
    }

    @Override
    public Notification update(Long id, NotificationUpdateRequest request) {
        Notification notification = notificationRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        notificationMapper.update(notificationMapper.fromUpdateRequest(request), notification);
        notificationRepository.save(notification);

        return notification;
    }

    @Override
    public void delete(Long id) {
        if (!notificationRepository.existsById(id)) {
            throw new RuntimeException("Not found");
        }

        notificationRepository.deleteById(id);
    }

    @Override
    public MessageResponse send(Long id) {
        return null;
    }
}
