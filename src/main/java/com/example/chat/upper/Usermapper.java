package com.example.chat.upper;

import com.example.chat.entiy.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Usermapper {

    @Select("select * from user")
    public List<User> getUsers();

    @Select("select * from [user] where user_name=#{name}")
    public User getUser(@Param("name") String name);

    @Insert("INSERT INTO [user] VALUES (#{userId}, #{email}, #{password}, #{avatar}, #{userName}, #{salt}, #{phone}, #{sex}, #{age}, #{status}, #{createTime}, #{updateTime})")
    public int insertUser(User user);

    @Delete("delete from users where name=#{name}")
    public int deleteUser(String name);

}
