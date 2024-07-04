package com.example.chat.upper;

import com.example.chat.entiy.Imsingle;
import com.example.chat.entiy.User;
import com.example.chat.entiy.unReadMessage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Usermapper {

    @Select("select * from [user]")
    public List<User> getUsers();

    @Select("select * from [user] where user_name=#{user_name}")
    @Results({
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "avatar", column = "avatar"),
            @Result(property = "user_name", column = "user_name"),
            @Result(property = "password", column = "password"),
            @Result(property = "salt", column = "salt"),
            @Result(property = "email", column = "email"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "age", column = "age"),
            @Result(property = "status", column = "status")
    })
    User getUser(String user_name);

    @Select("select user_name from [user] where user_id=#{user_id}")
    @Results({
            @Result(property = "user_id", column = "user_id"),
    })
    String getUserName(String user_id);

    @Select("select * from [message] where send_user=#{fromUser} and receive_user=#{toUser}")
    public List<Imsingle> findByUsername(String fromUser, String toUser);

    @Select("select * from [message] where send_user=#{fromUser} and receive_user=#{toUser} and is_read=0")
    List<unReadMessage> findUnReadNums(String fromUser, String toUser);

    @Insert("INSERT INTO [user] VALUES (#{user_id}, #{avatar},#{user_name}, #{password}, #{salt},#{email}, #{phone}, #{sex}, #{age}, #{status})")
    public int insertUser(User user);

    @Insert("insert into [message] values (#{handle},#{send_user} #{receive_user} #{content} #{is_read} #{creat_time})")
    int insertSelective(Imsingle imsingle);

    @Update("update [message] set is_read=#{is_read} where send_user=#{send_user} and receive_user=#{receive_user} and content=#{content}")
    int updateByPrimaryKey(Imsingle imsingle);

    @Update("update [user] set status=#{status} where user_id=#{user_id}")
    int updateStatus(User user);




}
