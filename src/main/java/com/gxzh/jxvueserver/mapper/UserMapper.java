package com.gxzh.jxvueserver.mapper;

import com.gxzh.jxvueserver.dto.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {


    List<User> selectUser(@Param("username") String username, @Param("password") String password);
}
