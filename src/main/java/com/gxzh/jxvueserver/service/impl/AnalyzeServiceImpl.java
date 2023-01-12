package com.gxzh.jxvueserver.service.impl;

import com.gxzh.jxvueserver.entity.*;
import com.gxzh.jxvueserver.mapper.AnalyzeMapper;
import com.gxzh.jxvueserver.service.AnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyzeServiceImpl implements AnalyzeService {
    @Autowired
    private AnalyzeMapper analyzeMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    private final String vuejx = "vuejx:analyze:";

    public List<Ywlx> selectYwlx(String depcode) {
        //先请求redis
        List<Ywlx> despList = null;
        Object o = redisTemplate.opsForValue().get(vuejx + "selectYwlx:" + depcode);
        if (o != null) {
            despList = (List<Ywlx>) o;
        } else {
            String code = "360000";

            if (depcode != null && depcode.indexOf("__") != -1) {

            } else {
                code = depcode.replace("%", "00");
            }
            despList = analyzeMapper.selectYwlx(depcode, code);
            redisTemplate.opsForValue().set(vuejx + "selectYwlx:" + depcode, despList);
        }
        return despList;
    }


    public List<Nywbl> selectNywbl(String depcode) {
        List<Nywbl> despList = null;
        Object o = redisTemplate.opsForValue().get(vuejx + "selectNywbl:" + depcode);
        if (o != null) {
            despList = (List<Nywbl>) o;
        } else {
            String code = "360000";

            if (depcode != null && depcode.indexOf("__") != -1) {

            } else {
                code = depcode.replace("%", "00");
            }
            despList = analyzeMapper.selectNywbl(depcode, code);
            redisTemplate.opsForValue().set(vuejx + "selectNywbl:" + depcode, despList);
        }
        return despList;
    }

    public List<Yywbl> selectYywbl(String depcode) {
        List<Yywbl> despList = null;
        Object o = redisTemplate.opsForValue().get(vuejx + "selectYywbl:" + depcode);
        if (o != null) {
            despList = (List<Yywbl>) o;
        } else {
            String code = "360000";

            if (depcode != null && depcode.indexOf("__") != -1) {

            } else {
                code = depcode.replace("%", "00");
            }
            despList = analyzeMapper.selectYywbl(depcode, code);
            redisTemplate.opsForValue().set(vuejx + "selectYywbl:" + depcode, despList);
        }
        return despList;
    }

    public List<Gdyw> selectGdyw(String depcode) {
        List<Gdyw> despList = null;
        Object o = redisTemplate.opsForValue().get(vuejx + "selectGdyw:" + depcode);
        if (o != null) {
            despList = (List<Gdyw>) o;
        } else {
            String code = "360000";

            if (depcode != null && depcode.indexOf("__") != -1) {

            } else {
                code = depcode.replace("%", "00");
            }
            despList = analyzeMapper.selectGdyw(depcode, code);
            redisTemplate.opsForValue().set(vuejx + "selectGdyw:" + depcode, despList);
        }


        return despList;
    }

    public List<Jryw> selectJryw(String depcode) {
        List<Jryw> despList = null;
        Object o = redisTemplate.opsForValue().get(vuejx + "selectJryw:" + depcode);
        if (o != null) {
            despList = (List<Jryw>) o;
        } else {
            String code = "360000";

            if (depcode != null && depcode.indexOf("__") != -1) {

            } else {
                code = depcode.replace("%", "00");
            }
            despList = analyzeMapper.selectJryw(depcode, code);
            redisTemplate.opsForValue().set(vuejx + "selectJryw:" + depcode, despList);
        }
        return despList;
    }
}
