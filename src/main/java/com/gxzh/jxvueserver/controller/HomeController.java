package com.gxzh.jxvueserver.controller;

import com.gxzh.jxvueserver.dto.*;
import com.gxzh.jxvueserver.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("api/home")
public class HomeController {
    @Autowired
    private HomeService homeService;
    @Autowired
    private RedisTemplate redisTemplate;

    private final String vuejx = "vuejx:home:";

    @RequestMapping("/sydwpie")
    public Res<?> selectSydwpie(@RequestParam("depCode") String depCode) {
        //先请求redis
        Object o = redisTemplate.opsForValue().get(vuejx + "sydwpie:" + depCode);
        SydwPie sydwPie = null;
        if (o != null) {
            sydwPie = (SydwPie) o;
        } else {
            sydwPie = this.homeService.selectSydwpie(depCode);
            redisTemplate.opsForValue().set(vuejx + "sydwpie:" + depCode, sydwPie, 2, TimeUnit.HOURS);
        }
        return Res.ok(sydwPie);
    }

    @RequestMapping("/xzjgpie")
    public Res<?> selectXzjgpie(@RequestParam("depCode") String depCode) {
        //先请求redis
        Object o = redisTemplate.opsForValue().get(vuejx + "xzjgpie:" + depCode);
        XzjgPie xzjgPie = null;
        if (o != null) {
            xzjgPie = (XzjgPie) o;
            ;
        } else {
            xzjgPie = this.homeService.selectXzjgpie(depCode);
            redisTemplate.opsForValue().set(vuejx + "xzjgpie:" + depCode, xzjgPie, 2, TimeUnit.HOURS);
        }
        return Res.ok(xzjgPie);
    }

    @RequestMapping("/bzqk")
    public Res<?> selectBzqk(@RequestParam("depCode") String depCode) {
        //先请求redis
        Object o = redisTemplate.opsForValue().get(vuejx + "bzqk:" + depCode);
        Bzqk bzqk = null;
        if (o != null) {
            bzqk = (Bzqk) o;
        } else {
            bzqk = this.homeService.selectBzqk(depCode);
            redisTemplate.opsForValue().set(vuejx + "bzqk:" + depCode, bzqk, 2, TimeUnit.HOURS);
        }
        return Res.ok(bzqk);
    }

    @RequestMapping("/xzldzs")
    public Res<?> selectxzldzs(@RequestParam("depCode") String depCode) {
        //先请求redis
        Object o = redisTemplate.opsForValue().get(vuejx + "xzldzs:" + depCode);
        Ldzs ldzs = null;
        if (o != null) {
            ldzs = (Ldzs) o;
        } else {
            ldzs = this.homeService.selectXzLdzs(depCode);
            redisTemplate.opsForValue().set(vuejx + "xzldzs:" + depCode, ldzs, 2, TimeUnit.HOURS);
        }
        return Res.ok(ldzs);
    }

    @RequestMapping("/syldzs")
    public Res<?> selectSyldzs(@RequestParam("depCode") String depCode) {
        //先请求redis
        Object o = redisTemplate.opsForValue().get(vuejx + "syldzs:" + depCode);
        Ldzs ldzs = null;
        if (o != null) {
            ldzs = (Ldzs) o;
        } else {
            ldzs = this.homeService.selectSyLdzs(depCode);
            redisTemplate.opsForValue().set(vuejx + "syldzs:" + depCode, ldzs, 2, TimeUnit.HOURS);
        }
        return Res.ok(ldzs);
    }
}
