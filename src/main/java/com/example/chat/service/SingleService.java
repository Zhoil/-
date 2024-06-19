package com.example.chat.service;

import com.example.chat.entiy.Imsingle;
import com.example.chat.entiy.unReadMessage;
import com.example.chat.upper.Usermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SingleService {


    @Autowired
    private Usermapper SingleDao;

    public Imsingle add(Imsingle imsingle) {
        SingleDao.insertSelective(imsingle);
        return imsingle;
    }

    public List<Imsingle> findByUsername(String fromUser, String toUser) {
        List<Imsingle> list = SingleDao.findByUsername(fromUser,toUser);
        list.forEach(x -> {
            if(x.getSend_user().equals(fromUser) && x.getReceive_user().equals(toUser)) {
                x.setIs_read(1);
                SingleDao.updateByPrimaryKey(x);
            }
        });
        return list;
    }

    public List<unReadMessage> findUnReadNums(String fromUser, String toUser) {

        return SingleDao.findUnReadNums(fromUser,toUser);
    }

}
