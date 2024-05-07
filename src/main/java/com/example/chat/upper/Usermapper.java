package com.example.chat.upper;

import com.example.chat.entiy.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Usermapper {

    @Select("select * from users")
    public List<User> getUsers();

    @Select("select * from users where name=#{name}")
    public User getUser(String name);

    @Select("select * from chatmessages where name=#{name}")
    public String getUserByChatMessage(String name);

    @Insert("insert into users values(#{name},#{email},#{password})")
    public int insertUser(User user);

    @Delete("delete from users where name=#{name}")
    public int deleteUser(String name);

}
