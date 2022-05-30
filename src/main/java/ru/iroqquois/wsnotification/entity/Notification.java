package ru.iroqquois.wsnotification.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private NotificationType type;

    private String title;

    private String content;

    private LocalDate lastSentAt;

    public enum NotificationType {
        SUCCESS,
        WARNING,
        FAIL
    }
}
