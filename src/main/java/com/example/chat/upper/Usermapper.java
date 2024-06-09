package com.example.chat.upper;

import com.example.chat.entiy.Mess_save;
import com.example.chat.entiy.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Usermapper {

    @Select("select * from users")
    public List<User> getUsers();

    @Select("select * from users where name=#{name}")
    public User getUser(String name);

    @Select("select * from chatmessages where name_of=#{name_of} and name_to=#{name_to}")
    public List<String> getUserByChatMessage(String name_of,String name_to);

    @Insert("insert into users values(#{name},#{email},#{password})")
    public int insertUser(User user);

    @Insert("insert into chatmessages values(#{name_of},#{message},#{name_to})")
    public int insertMessage(Mess_save mess);

    @Delete("delete from users where name=#{name}")
    public int deleteUser(String name);

}
