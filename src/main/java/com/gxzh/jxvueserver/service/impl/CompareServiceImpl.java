package com.gxzh.jxvueserver.service.impl;


import com.gxzh.jxvueserver.entity.Ldzs;
import com.gxzh.jxvueserver.entity.Rkbz;
import com.gxzh.jxvueserver.entity.Sybzpzbd;
import com.gxzh.jxvueserver.entity.Xzbzpzbd;
import com.gxzh.jxvueserver.mapper.CompareMapper;
import com.gxzh.jxvueserver.service.CompareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompareServiceImpl implements CompareService {
    @Autowired
    private CompareMapper compareMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    private final String vuejx = "vuejx:compare:";


    public List<Ldzs> selectLdzs(String depcode){
        String code ="360000";
        List<Ldzs> despList=null;
        if(depcode!=null && depcode.indexOf("__")!=-1){
            depcode="36%";
        }else{
            code=depcode.replace("%","00");
        }
        Object o = redisTemplate.opsForValue().get(vuejx + "selectLdzs:" + depcode);
        if (o != null) {
            despList = (List<Ldzs>) o;
        } else {
            despList= compareMapper.selectLdzs(depcode,code);
            redisTemplate.opsForValue().set(vuejx + "selectLdzs:" + depcode, despList);
        }
      return despList;
    }

    public List<Xzbzpzbd> selectXzbzpzbd(String depcode){
        String code ="360000";
        List<Xzbzpzbd> despList=null;
        if(depcode!=null && depcode.indexOf("__")!=-1){
            depcode="36%";
        }else{
            code=depcode.replace("%","00");
        }
        Object o = redisTemplate.opsForValue().get(vuejx + "selectXzbzpzbd:" + depcode);
        if (o != null) {
            despList = (List<Xzbzpzbd>) o;
        } else {

            despList= compareMapper.selectXzbzpzbd(depcode,code);
            redisTemplate.opsForValue().set(vuejx + "selectXzbzpzbd:" + depcode, despList);
        }


        return despList;
    }

    public List<Sybzpzbd> selectSybzpzbd(String depcode){
        String code ="360000";
        List<Sybzpzbd> despList=null;
        if(depcode!=null && depcode.indexOf("__")!=-1){
            depcode="36%";
        }else{
            code=depcode.replace("%","00");
        }
        Object o = redisTemplate.opsForValue().get(vuejx + "selectSybzpzbd:" + depcode);
        if (o != null) {
            despList = (List<Sybzpzbd>) o;
        } else {

            despList= compareMapper.selectSybzpzbd(depcode,code);
            redisTemplate.opsForValue().set(vuejx + "selectSybzpzbd:" + depcode, despList);
        }
        return despList;
    }


    public List<Rkbz> selectRkBzZb(String depcode){
        String code ="360000";
        List<Rkbz> despList=null;
        if(depcode!=null && depcode.indexOf("__")!=-1){
            depcode="36%";
        }else{
            code=depcode.replace("%","00");
        }
        Object o = redisTemplate.opsForValue().get(vuejx + "selectRkBzZb:" + depcode);
        if (o != null) {
            despList = (List<Rkbz>) o;
        } else {

            despList= compareMapper.selectRkBzZb(depcode,code);
            redisTemplate.opsForValue().set(vuejx + "selectRkBzZb:" + depcode, despList);
        }
        return despList;
    }

}
