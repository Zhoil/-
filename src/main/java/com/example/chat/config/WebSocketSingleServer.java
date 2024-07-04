package com.example.chat.config;

import cn.hutool.json.JSONUtil;
import com.example.chat.entiy.Imsingle;
import com.example.chat.service.SingleService;
import jakarta.annotation.Resource;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *   单聊服务
 */

@ServerEndpoint(value = "/serverSingle")
@Component
public class WebSocketSingleServer implements InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(WebSocketSingleServer.class);
    /**
     * 当前连接数量
     */
    public static final Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    @Resource
    SingleService ServerSingleService;

    static SingleService staticServerSingleService;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        sessionMap.put(session.getId(), session);
        log.info("[OnOpen] 新建连接,session={},当前在线人数为：{}", session.getId(),sessionMap.size());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        sessionMap.remove(session.getId());
        log.info("[OnClos] 有一连接关闭,session={},当前在线人数为：{}", session.getId(),sessionMap.size());
    }

    /**
     * 收到客户端消失时调用的方法
     * 后台收到客户端发送过来的消息
     * onMessage 是一个消息的中转站
     * 接受 浏览器端 socket.send 发送过来的 json数据、
     *
     * @param message 客户端发来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("服务端收到消息:{}", message);
        Imsingle imsingle = JSONUtil.toBean(message, Imsingle.class);
        //存储到数据库
        staticServerSingleService.add(imsingle);
        String jsonStr = JSONUtil.toJsonStr(imsingle); // 处理后的消息体
        this.sendAllMessage(jsonStr);
        log.info("[OnMessage] 发送消息:{}", jsonStr);
    }

    @OnError
    public void onError(Session session, Throwable throwable) { log.info("[OnError] 发生错误", throwable); }

    /**
     * 服务端发送消息给除了自己的其他客户端
     */
    private void sendMessage(Session fromSession, String message) {
        sessionMap.values().forEach(session -> {
            if(fromSession != session) {
                log.info("服务端给客户端[{}]发送消息{}",session.getId(),message);
                try {
                    session.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    log.info("服务端发送消息给客户端异常",e);
                }
            }
        });
    }

    /**
     * 服务端发送消息给所有客户端
     */
    private void sendAllMessage(String message) {
        try {
            for(Session session : sessionMap.values()) {
                log.info("服务端给客户端[{}]发送消息{}",session.getId(),message);
                session.getBasicRemote().sendText(message);
            }
        } catch (IOException e) {
            log.info("服务端发送消息给客户端异常",e);
        }
    }


    @Override
    public void afterPropertiesSet() throws Exception { staticServerSingleService = ServerSingleService; }

}
