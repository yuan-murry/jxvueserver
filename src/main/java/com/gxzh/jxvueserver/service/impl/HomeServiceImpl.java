package com.gxzh.jxvueserver.service.impl;

import com.gxzh.jxvueserver.dto.Bzqk;
import com.gxzh.jxvueserver.dto.Ldzs;
import com.gxzh.jxvueserver.dto.SydwPie;
import com.gxzh.jxvueserver.dto.XzjgPie;
import com.gxzh.jxvueserver.mapper.HomeMapper;
import com.gxzh.jxvueserver.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeMapper homeMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    private final String vuejx = "vuejx:home:";

    @Override
    public SydwPie selectSydwpie(String depCode) {
        //先请求redis
        Object o = redisTemplate.opsForValue().get(vuejx + "sydwpie:" + depCode);
        SydwPie sydwPie = null;
        if (o != null) {
            sydwPie = (SydwPie) o;
        } else {
            sydwPie = homeMapper.selectSydwpie(depCode);
            if (sydwPie == null) {
                sydwPie = new SydwPie();
                redisTemplate.opsForValue().set(vuejx + "sydwpie:" + depCode, sydwPie);
            }
        }
        return sydwPie;
    }

    @Override
    public XzjgPie selectXzjgpie(String depCode) {
        //先请求redis
        Object o = redisTemplate.opsForValue().get(vuejx + "xzjgpie:" + depCode);
        XzjgPie xzjgPie = null;
        if (o != null) {
            xzjgPie = (XzjgPie) o;
        } else {
            xzjgPie = homeMapper.selectXzjgpie(depCode);
            if (xzjgPie == null) {
                xzjgPie = new XzjgPie();
            }
            redisTemplate.opsForValue().set(vuejx + "xzjgpie:" + depCode, xzjgPie);
        }
        return xzjgPie;
    }

    @Override
    public Bzqk selectBzqk(String depCode) {
        //先请求redis
        Object o = redisTemplate.opsForValue().get(vuejx + "bzqk:" + depCode);
        Bzqk bzqk = null;
        if (o != null) {
            bzqk = (Bzqk) o;
        } else {
            bzqk = homeMapper.selectBzqk(depCode);
            if (bzqk == null) {
                bzqk = new Bzqk();
            }
            redisTemplate.opsForValue().set(vuejx + "bzqk:" + depCode, bzqk);
        }
        return bzqk;
    }

    @Override
    public Ldzs selectXzLdzs(String depCode) {
        //先请求redis
        Object o = redisTemplate.opsForValue().get(vuejx + "xzldzs:" + depCode);
        Ldzs ldzs = null;
        if (o != null) {
            ldzs = (Ldzs) o;
        } else {
            ldzs = homeMapper.selectXzLdzs(depCode);
            if (ldzs == null) {
                ldzs = new Ldzs();
            }
            redisTemplate.opsForValue().set(vuejx + "xzldzs:" + depCode, ldzs);
        }
        return ldzs;
    }

    @Override
    public Ldzs selectSyLdzs(String depCode) {
        //先请求redis
        Object o = redisTemplate.opsForValue().get(vuejx + "syldzs:" + depCode);
        Ldzs ldzs = null;
        if (o != null) {
            ldzs = (Ldzs) o;
        } else {
            ldzs = homeMapper.selectSyLdzs(depCode);
            if (ldzs == null) {
                ldzs = new Ldzs();
            }
            redisTemplate.opsForValue().set(vuejx + "syldzs:" + depCode, ldzs);
        }
        return ldzs;
    }

    @Override
    public String testbase() {
        return homeMapper.testbase();
    }
}
