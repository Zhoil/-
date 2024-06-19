package com.example.chat.entiy;

import com.example.chat.entiy.User;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class MessageForm {

    // 发送用户和接收用户完整聊天消息列表
    private List<unReadMessage> messages = new ArrayList<>();
    // 未读消息数量
    private Integer noReadMessageLength;
    // 在线标识
    private Boolean isOnline;
    // 发送信息用户
    private User sendUser;
    // 接收信息用户,偏向于赋值登录人员用户信息
    private User receiveUser;
    // 最新一条聊天记录
    private String lastMessage;
}

