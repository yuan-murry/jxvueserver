package com.gxzh.jxvueserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxzh.jxvueserver.dto.AreaBusinessChild;
import com.gxzh.jxvueserver.dto.YwlxChild;
import com.gxzh.jxvueserver.entity.*;
import com.gxzh.jxvueserver.mapper.AnalyzeMapper;
import com.gxzh.jxvueserver.service.AnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalyzeServiceImpl implements AnalyzeService {
    @Autowired
    private AnalyzeMapper analyzeMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    private final String vuejx = "vuejx:analyze:";

    @Override
    public List<Ywlx> selectYwlx(String depcode) {
        //先请求redis
        String code = "360000";
        List<Ywlx> despList = null;
        if (depcode != null && depcode.indexOf("__") != -1) {
            depcode="36%";
        } else {
            code = depcode.replace("%", "00");
        }
        Object o = redisTemplate.opsForValue().get(vuejx + "selectYwlx:" + depcode);
        if (o != null) {
            despList = (List<Ywlx>) o;
        } else {

            despList = analyzeMapper.selectYwlx(depcode, code);
            redisTemplate.opsForValue().set(vuejx + "selectYwlx:" + depcode, despList);
        }
        return despList;
    }


    @Override
    public List<Nywbl> selectNywbl(String depcode) {
        String code = "360000";
        List<Nywbl> despList = null;
        if (depcode != null && depcode.indexOf("__") != -1) {
            depcode="36%";
        } else {
            code = depcode.replace("%", "00");
        }
        Object o = redisTemplate.opsForValue().get(vuejx + "selectNywbl:" + depcode);
        if (o != null) {
            despList = (List<Nywbl>) o;
        } else {



            despList = analyzeMapper.selectNywbl(depcode, code);
            redisTemplate.opsForValue().set(vuejx + "selectNywbl:" + depcode, despList);
        }
        return despList;
    }

    @Override
    public List<Yywbl> selectYywbl(String depcode) {
        String code = "360000";
        List<Yywbl> despList = null;
        if (depcode != null && depcode.indexOf("__") != -1) {
            depcode="36%";
        } else {
            code = depcode.replace("%", "00");
        }
        Object o = redisTemplate.opsForValue().get(vuejx + "selectYywbl:" + depcode);
        if (o != null) {
            despList = (List<Yywbl>) o;
        } else {
            despList = analyzeMapper.selectYywbl(depcode, code);
            redisTemplate.opsForValue().set(vuejx + "selectYywbl:" + depcode, despList);
        }
        return despList;
    }

    @Override
    public List<Gdyw> selectGdyw(String depcode) {
        String code = "360000";
        List<Gdyw> despList = null;

        if (depcode != null && depcode.indexOf("__") != -1) {
            depcode="36%";
        } else {
            code = depcode.replace("%", "00");
        }
        Object o = redisTemplate.opsForValue().get(vuejx + "selectGdyw:" + depcode);
        if (o != null) {
            despList = (List<Gdyw>) o;
        } else {
            despList = analyzeMapper.selectGdyw(depcode, code);
            redisTemplate.opsForValue().set(vuejx + "selectGdyw:" + depcode, despList);
        }


        return despList;
    }

    @Override
    public List<Jryw> selectJryw(String depcode) {
        String code = "360000";
        List<Jryw> despList = null;
        if (depcode != null && depcode.indexOf("__") != -1) {
            depcode="36%";
        } else {
            code = depcode.replace("%", "00");
        }
        Object o = redisTemplate.opsForValue().get(vuejx + "selectJryw:" + depcode);
        if (o != null) {
            despList = (List<Jryw>) o;
        } else {
            despList = analyzeMapper.selectJryw(depcode, code);
            redisTemplate.opsForValue().set(vuejx + "selectJryw:" + depcode, despList);
        }
        return despList;
    }

    @Override
    public AreaBusinessChild getAreaBusinessChild(String depName) {
        AreaBusinessChild areaBusinessChild = analyzeMapper.getAreaBusinessChild(depName);
        return areaBusinessChild;
    }



    @Override
    public PageInfo<YwlxChild> selectYwlxChild(String depCode, String codeValue, int pageNum, int pageSize) {
        if (depCode != null && depCode.indexOf("__") != -1) {
            depCode="36%";
        }
        List<YwlxChild> ywlxChildList = null;

        PageHelper.startPage(pageNum,pageSize);
        ywlxChildList = analyzeMapper.selectYwlxChild(depCode,codeValue);
        if (ywlxChildList == null) {
            ywlxChildList = new ArrayList<>();
        }

        PageInfo<YwlxChild> pageList=new PageInfo<>(ywlxChildList);


        return pageList;
    }
}
