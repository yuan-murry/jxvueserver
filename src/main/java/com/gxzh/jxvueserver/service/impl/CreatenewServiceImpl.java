package com.gxzh.jxvueserver.service.impl;


import com.gxzh.jxvueserver.entity.Createnew;
import com.gxzh.jxvueserver.mapper.CreatenewMapper;
import com.gxzh.jxvueserver.service.CreatenewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatenewServiceImpl implements CreatenewService {

    @Autowired
    private CreatenewMapper createnewMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    private final String vuejx = "vuejx:createnew:";

    @Override
    public List<Createnew> selectCreatenew(String depcode) {
        List<Createnew> despList=null;
        Object o = redisTemplate.opsForValue().get(vuejx + "selectCreatenew:" + depcode);
        if (o != null) {
            despList = (List<Createnew>) o;
        } else {
            String code ="360000";
            if(depcode!=null && depcode.indexOf("__")!=-1){
                depcode="36%";
            }else{
                code=depcode.replace("%","00");
            }
            despList= createnewMapper.selectCreatenew(depcode,code);
            redisTemplate.opsForValue().set(vuejx + "selectCreatenew:" + depcode, despList);
        }
        return despList;
    }
}
