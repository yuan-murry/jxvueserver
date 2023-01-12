package com.gxzh.jxvueserver.service.impl;

import com.gxzh.jxvueserver.entity.Cbz;
import com.gxzh.jxvueserver.entity.Ywtjg;
import com.gxzh.jxvueserver.mapper.WtyjMapper;
import com.gxzh.jxvueserver.service.WtyjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WtyjServiceImpl implements WtyjService {
    @Autowired
    private WtyjMapper wtyjMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    private final String vuejx = "vuejx:wtyj:";

    public List<Cbz> selectCbz(String depcode) {
        String code = "360000";
        List<Cbz> despList = null;
        Object o = redisTemplate.opsForValue().get(vuejx + "selectCbz:" + depcode);
        if (o != null) {
            despList = (List<Cbz>) o;
        } else {
            if (depcode != null && depcode.indexOf("__") != -1) {

            } else {
                code = depcode.replace("%", "00");
            }
            despList = wtyjMapper.selectCbz(depcode, code);
            redisTemplate.opsForValue().set(vuejx + "selectCbz:" + depcode, despList);
        }
        return despList;
    }

    public List<Ywtjg> selectYwtjg(String depcode) {
        String code = "360000";
        List<Ywtjg> despList = null;
        Object o = redisTemplate.opsForValue().get(vuejx + "selectYwtjg:" + depcode);
        if (o != null) {
            despList = (List<Ywtjg>) o;
        } else {
            if (depcode != null && depcode.indexOf("__") != -1) {

            } else {
                code = depcode.replace("%", "00");
            }
            despList = wtyjMapper.selectYwtjg(depcode, code);
            redisTemplate.opsForValue().set(vuejx + "selectYwtjg:" + depcode, despList);
        }
        return despList;
    }
}
