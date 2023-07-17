package com.gxzh.jxvueserver.service.impl;

import com.gxzh.jxvueserver.util.Md5Util;
import com.gxzh.jxvueserver.util.Token;
import com.gxzh.jxvueserver.dto.User;
import com.gxzh.jxvueserver.mapper.UserMapper;
import com.gxzh.jxvueserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String selectUser(String username, String password) {
        String token="";
       String pwd= Md5Util.MD5(password);
       List<User> userList= userMapper.selectUser(username,pwd);
       User u= userList.get(0);

        if(u.getLogincount()>0){
            token=Token.generateToken(username,password,new Date());
        }

        return token;
    }
}
