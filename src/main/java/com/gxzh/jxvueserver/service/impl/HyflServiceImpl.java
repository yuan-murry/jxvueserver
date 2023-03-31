package com.gxzh.jxvueserver.service.impl;


import com.gxzh.jxvueserver.dto.BzzyIndstry;
import com.gxzh.jxvueserver.mapper.HyflMapper;
import com.gxzh.jxvueserver.service.HyflService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HyflServiceImpl implements HyflService {
    @Autowired
    private HyflMapper hyflMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    private final String vuejx = "vuejx:hyfl:";

    @Override
    public List<BzzyIndstry> getInsdstry(String depCode) {
        List<BzzyIndstry> insdstry = null;
        Object o = redisTemplate.opsForValue().get(vuejx + "getInsdstry:" + depCode);
        if (o != null) {
            insdstry = (List<BzzyIndstry>) o;
        } else {
            if (!"36%".equals(depCode)) {
                depCode = depCode.substring(0, 4) + "%";
            }
            insdstry = hyflMapper.getInsdstry(depCode);
            redisTemplate.opsForValue().set(vuejx + "getInsdstry:" + depCode, insdstry);
        }

        return insdstry;
    }

    @Override
    public List<BzzyIndstry> getInsdstryChild(String depCode, String flCode) {
        List<BzzyIndstry> insdstry = null;
        Object o = redisTemplate.opsForValue().get(vuejx + "getInsdstryChild:" + depCode + flCode);
        if (o != null) {
            insdstry = (List<BzzyIndstry>) o;
        } else {
            if (!"36%".equals(depCode)) {
                depCode = depCode.substring(0, 4) + "%";
            }
            insdstry = hyflMapper.getInsdstryChild(depCode, flCode + "%");
            redisTemplate.opsForValue().set(vuejx + "getInsdstryChild:" + depCode + flCode, insdstry);
        }

        return insdstry;
    }


}
