package com.example.chat.upper;

import com.example.chat.entiy.Imsingle;
import com.example.chat.entiy.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Usermapper {

    @Select("select * from user")
    public List<User> getUsers();

    @Select("select * from [user] where user_name=#{name}")
    public User getUser(String name);

    @Insert("INSERT INTO [user] VALUES (#{userId}, #{email}, #{password}, #{avatar}, #{userName}, #{salt}, #{phone}, #{sex}, #{age}, #{status}, #{createTime}, #{updateTime})")
    public int insertUser(User user);

    @Delete("delete from users where name=#{name}")
    public int deleteUser(String name);

    @Select("select * from [message] where send_user=#{fromUser} and receive_user=#{toUser}")
    public List<Imsingle> findByUsername(String fromUser, String toUser);

    @Update("update [message] set is_read=#{is_read} where send_user=#{send_user} and receive_user=#{receive_user}")
    int updateByPrimaryKey(Imsingle imsingle);

    @Insert("insert into [message] values (#{send_user} #{receive_user} #{content} #{is_read} #{creat_time})")
    int insertSelective(Imsingle imsingle);

}
