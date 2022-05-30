package ru.iroqquois.wsnotification.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import ru.iroqquois.wsnotification.entity.Notification;
import ru.iroqquois.wsnotification.payload.request.NotificationCreateRequest;
import ru.iroqquois.wsnotification.payload.request.NotificationUpdateRequest;
import ru.iroqquois.wsnotification.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    private final SimpMessagingTemplate webSocket;

    @GetMapping("/notifications")
    public List<Notification> getAll() {
        return notificationService.getList();
    }

    @PostMapping("/notifications")
    public Notification create(@RequestBody NotificationCreateRequest request) {
        return notificationService.create(request);
    }

    @PutMapping("/notifications/{id}")
    public Notification update(@PathVariable Long id, @RequestBody NotificationUpdateRequest request) {
        return notificationService.update(id, request);
    }

    @DeleteMapping("/notifications/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        notificationService.delete(id);

        return new ResponseEntity<>("Notification deleted", HttpStatus.OK);
    }

    @PostMapping("/notifications/{id}/send")
    public ResponseEntity<String>send(@PathVariable  Long id) {
        Notification notification = notificationService.get(id);
        webSocket.convertAndSend("/topic/notification", notification);

        return new ResponseEntity<>("Notification sent", HttpStatus.OK);
    }
}
