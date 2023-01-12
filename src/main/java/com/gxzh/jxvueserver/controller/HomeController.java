package com.gxzh.jxvueserver.controller;

import com.gxzh.jxvueserver.dto.*;
import com.gxzh.jxvueserver.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("api/home")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @RequestMapping("/sydwpie")
    public Res<?> selectSydwpie(@RequestParam("depCode") String depCode) {
        SydwPie sydwPie = this.homeService.selectSydwpie(depCode);
        return Res.ok(sydwPie);
    }

    @RequestMapping("/xzjgpie")
    public Res<?> selectXzjgpie(@RequestParam("depCode") String depCode) {
        XzjgPie xzjgPie = this.homeService.selectXzjgpie(depCode);
        return Res.ok(xzjgPie);
    }

    @RequestMapping("/bzqk")
    public Res<?> selectBzqk(@RequestParam("depCode") String depCode) {
        Bzqk bzqk = this.homeService.selectBzqk(depCode);
        return Res.ok(bzqk);
    }

    @RequestMapping("/xzldzs")
    public Res<?> selectxzldzs(@RequestParam("depCode") String depCode) {
        Ldzs ldzs = this.homeService.selectXzLdzs(depCode);
        return Res.ok(ldzs);
    }

    @RequestMapping("/syldzs")
    public Res<?> selectSyldzs(@RequestParam("depCode") String depCode) {
        Ldzs ldzs = this.homeService.selectSyLdzs(depCode);
        return Res.ok(ldzs);
    }

}
