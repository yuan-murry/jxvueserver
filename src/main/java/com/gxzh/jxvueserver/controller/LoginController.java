package com.gxzh.jxvueserver.controller;


import com.gxzh.jxvueserver.dto.Res;
import com.gxzh.jxvueserver.service.UserService;
import com.gxzh.jxvueserver.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/login")
public class LoginController {
    @Autowired
    private UserService userService;


    @RequestMapping("/toLogin")
    public Res<?> toLogin(@RequestParam("username") String username,@RequestParam("password") String password) {
       String token = this.userService.selectUser(username,password);
       if(token!=null&&!token.equals("")){
           return Res.ok(token);
       }else{
           return Res.fail("请确保登录用户为省编办，并确保用户名以及密码正确");
       }

    }


    @RequestMapping("/loginOut")
    public Res<?> loginOut() {

        Token.tokenvalue="";
        return Res.ok("退出成功");


    }
}
