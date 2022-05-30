package ru.iroqquois.wsnotification.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationCreateRequest {
    private String title;
    private String content;
    private LocalDate lastSentAt;
}
