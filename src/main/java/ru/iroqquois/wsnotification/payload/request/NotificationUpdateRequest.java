package ru.iroqquois.wsnotification.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class NotificationUpdateRequest {
    private String title;
    private String content;
    private LocalDate lastSentAt;
}
