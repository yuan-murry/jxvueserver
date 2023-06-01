package com.gxzh.jxvueserver.service.impl;

import com.gxzh.jxvueserver.dto.VtxPie;
import com.gxzh.jxvueserver.dto.WtyjJgsy;
import com.gxzh.jxvueserver.entity.*;
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

    @Override
    public List<Cbz> selectCbz(String depcode) {
        String code = "360000";
        List<Cbz> despList = null;
        if (depcode != null && depcode.indexOf("__") != -1) {
            depcode = "36%";
        } else {
            code = depcode.replace("%", "00");
        }
        Object o = redisTemplate.opsForValue().get(vuejx + "selectCbz:" + depcode);
        if (o != null) {
            despList = (List<Cbz>) o;
        } else {

            despList = wtyjMapper.selectCbz(depcode, code);
            redisTemplate.opsForValue().set(vuejx + "selectCbz:" + depcode, despList);
        }
        return despList;
    }

    @Override
    public List<Ywtjg> selectYwtjg(String depcode) {
        String code = "360000";
        List<Ywtjg> despList = null;
        if (depcode != null && depcode.indexOf("__") != -1) {
            depcode="36%";
        } else {
            code = depcode.replace("%", "00");
        }
        Object o = redisTemplate.opsForValue().get(vuejx + "selectYwtjg:" + depcode);
        if (o != null) {
            despList = (List<Ywtjg>) o;
        } else {

            despList = wtyjMapper.selectYwtjg(depcode, code);
            redisTemplate.opsForValue().set(vuejx + "selectYwtjg:" + depcode, despList);
        }
        return despList;
    }

    @Override
    public List<Azwtlx> selectAzwtlx(String depcode) {
        String code = "360000";
        List<Azwtlx> despList = null;
        if (depcode != null && depcode.indexOf("__") != -1) {
            depcode="36%";
        } else {
            code = depcode.replace("%", "00");
        }
        Object o = redisTemplate.opsForValue().get(vuejx + "selectAzwtlx:" + depcode);
        if (o != null) {
            despList = (List<Azwtlx>) o;
        } else {

            despList = wtyjMapper.selectAzwtlx(depcode, code);
            redisTemplate.opsForValue().set(vuejx + "selectAzwtlx:" + depcode, despList);
        }
        return despList;
    }

    @Override
    public List<Azzgfs> selectAzzgfs(String depcode) {
        String code = "360000";
        List<Azzgfs> despList = null;
        if (depcode != null && depcode.indexOf("__") != -1) {
            depcode="36%";
        } else {
            code = depcode.replace("%", "00");
        }
        Object o = redisTemplate.opsForValue().get(vuejx + "selectAzzgfs:" + depcode);
        if (o != null) {
            despList = (List<Azzgfs>) o;
        } else {

            despList = wtyjMapper.selectAzzgfs(depcode, code);
            redisTemplate.opsForValue().set(vuejx + "selectAzzgfs:" + depcode, despList);
        }
        return despList;
    }

    @Override
    public List<Ywttz> selectYwttz(String depcode) {
        String code = "360000";
        List<Ywttz> despList = null;
        if (depcode != null && depcode.indexOf("__") != -1) {
            depcode="36%";
        } else {
            code = depcode.replace("%", "00");
        }
        Object o = redisTemplate.opsForValue().get(vuejx + "selectYwttz:" + depcode);
        if (o != null) {
            despList = (List<Ywttz>) o;
        } else {

            despList = wtyjMapper.selectYwttz(depcode, code);
            redisTemplate.opsForValue().set(vuejx + "selectYwttz:" + depcode, despList);
        }
        return despList;
    }

    @Override
    public List<WtyjJgsy> getextraPieChild(String depCode, String jgsyNum) {
        if (depCode != null && depCode.indexOf("__") != -1) {
            depCode = "36%";
        }
        List<WtyjJgsy> jgsyList = wtyjMapper.getextraPieChild(depCode, jgsyNum);
        return jgsyList;
    }



    @Override
    public List<WtyjJgsy> selectextraPieChildDetail(String depName,String classNum) {

        List<WtyjJgsy> jgsyList = null;

        Object o = redisTemplate.opsForValue().get(vuejx + "selectextraPieChildDetail:" + depName+classNum);
        if (o != null) {
            jgsyList = (List<WtyjJgsy>) o;
        } else {

            jgsyList = wtyjMapper.selectextraPieChildDetail(depName, classNum);
            redisTemplate.opsForValue().set(vuejx + "selectextraPieChildDetail:" + depName+classNum, jgsyList);
        }
        return jgsyList;
    }

    @Override
    public List<VtxPie> selectLTX(String depcode) {
          String code = "360000";
        List<VtxPie> despList = null;
       if (depcode != null && depcode.indexOf("__") != -1) {
            depcode="36%";
        } else {
            code = depcode.replace("%", "00");
        }
        Object o = redisTemplate.opsForValue().get(vuejx + "selectLTX:" + depcode);
        if (o != null) {
            despList = (List<VtxPie>) o;
        } else {

            despList = wtyjMapper.selectLTX(depcode,code);
            redisTemplate.opsForValue().set(vuejx + "selectLTX:" + depcode, despList);
        }
        return despList;
    }

}



