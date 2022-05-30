package ru.iroqquois.wsnotification.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import ru.iroqquois.wsnotification.payload.response.PingResponse;

@Controller
@CrossOrigin
@RequiredArgsConstructor
@EnableScheduling
public class TestController {
    private final SimpMessagingTemplate webSocket;

    @Scheduled(fixedRate = 2000)
    public void ping() {
        webSocket.convertAndSend("/topic/notification", new PingResponse("ping"));
    }
}
