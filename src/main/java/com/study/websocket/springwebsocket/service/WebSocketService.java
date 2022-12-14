package com.study.websocket.springwebsocket.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * web socket service
 *
 * @author 王贤
 */
@Service
@Slf4j
public class WebSocketService {

    private final Map<String, WebSocketSession> sessionMap = new ConcurrentHashMap<>();

    public void put(String id, WebSocketSession session) {
        sessionMap.put(id, session);
        log.info("webSocket connection {} open, now:{}", id, sessionMap.size());
    }

    public void onMessage(String id, TextMessage message) {
        if (sessionMap.containsKey(id)) {
            try {
                sessionMap.get(id).sendMessage(message);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        } else {
            log.error("websocket session {} is expired.", id);
        }
    }

    public void remove(String id) {
        if (sessionMap.containsKey(id)) {
            try {
                sessionMap.get(id).close();
                sessionMap.remove(id);
                log.info("websocket connection {} closed,now:{}", id, sessionMap.size());
            } catch (IOException e) {
                log.error("Failed to close session {}", id);
            }
        }
    }
}

