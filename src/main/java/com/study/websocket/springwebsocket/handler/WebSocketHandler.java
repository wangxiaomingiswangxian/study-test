package com.study.websocket.springwebsocket.handler;

import com.study.websocket.springwebsocket.service.WebSocketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author 王贤
 */
@Slf4j
@Service
public class WebSocketHandler extends TextWebSocketHandler {
    private WebSocketService webSocketService;
    @Autowired
    public WebSocketHandler(WebSocketService webSocketService){
        this.webSocketService=webSocketService;
    }

    /**
     * 建立链接后的事件监听
     * @param session session
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session){
        log.info("sessionId {} established",session.getId());
        webSocketService.put(session.getId(),session);
    }

    /**
     * 文本消息的事件处理
     *
     * @param session session
     * @param message Message
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message){
        log.info("get message from sessionId {} whit message {} " ,session.getId(),message);
        webSocketService.onMessage(session.getId(),message);
    }

    /**
     * 传输失败事件处理
     *
     * @param session session
     * @param exception Exception
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        webSocketService.remove(session.getId());
    }

    /**
     * 链接断开事件处理
     *
     * @param session session
     * @param status close Status
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status){
        webSocketService.remove(session.getId());
    }

    /**
     * 配置是否支持部分消息
     */
    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
