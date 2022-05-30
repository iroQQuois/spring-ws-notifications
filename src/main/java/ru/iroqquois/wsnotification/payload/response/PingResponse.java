package ru.iroqquois.wsnotification.payload.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Getter
public class PingResponse {
    protected UUID id;
    private String body;

    public PingResponse(String body) {
        this.id = UUID.randomUUID();
        this.body = body;
    }
}
