package com.gxzh.jxvueserver.controller;

import com.gxzh.jxvueserver.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @RequestMapping("/testIn")
    public String testInterface(){
        String s = this.homeService.selectJgsyName();
        return s;
    }
}
