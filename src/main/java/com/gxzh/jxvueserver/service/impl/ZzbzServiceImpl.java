package com.gxzh.jxvueserver.service.impl;

import com.gxzh.jxvueserver.dto.*;
import com.gxzh.jxvueserver.mapper.ZzbzMapper;
import com.gxzh.jxvueserver.service.ZzbzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZzbzServiceImpl implements ZzbzService {
    @Autowired
    private ZzbzMapper zzbzMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    private final String vuejx = "vuejx:zzbz:";

    @Override
    public ZzbzUseCondition getUseCondition(String depCode) {
        String tempdep = depCode;
        Object o = redisTemplate.opsForValue().get(vuejx + "getUseCondition:" + depCode);
        ZzbzUseCondition zzbzUseCondition = null;
        if (o != null) {
            zzbzUseCondition = (ZzbzUseCondition) o;
        } else {
            if (!"36%".equals(depCode)) {
                depCode = depCode.substring(0, 4) + "%";
            }
            zzbzUseCondition = zzbzMapper.getUseCondition(depCode);
            redisTemplate.opsForValue().set(vuejx + "getUseCondition:" + tempdep, zzbzUseCondition);
        }

        return zzbzUseCondition;
    }

    @Override
    public List<ZzbzAllot> getZzbzAllot(String depCode) {
        List<ZzbzAllot> zzbzAllotList = null;
        Object o = redisTemplate.opsForValue().get(vuejx + "getZzbzAllot:" + depCode);
        if (o != null) {
            zzbzAllotList = (List<ZzbzAllot>) o;
        } else {
            if ("36%".equals(depCode)) {
                zzbzAllotList = zzbzMapper.getZzbzAllot_sheng();
            } else {
                zzbzAllotList = zzbzMapper.getZzbzAllot_shi(depCode.substring(0, 4) + "%", depCode);
            }
            redisTemplate.opsForValue().set(vuejx + "getZzbzAllot:" + depCode, zzbzAllotList);
        }

        return zzbzAllotList;
    }

    @Override
    public ZzbzStaffDuty getStaffDuty(String depCode) {
        String tempdep = depCode;
        ZzbzStaffDuty zzbzStaffDuty = null;
        Object o = redisTemplate.opsForValue().get(vuejx + "getStaffDuty:" + depCode);
        if (o != null) {
            zzbzStaffDuty = (ZzbzStaffDuty) o;
        } else {
            if (!"36%".equals(depCode)) {
                depCode = depCode.substring(0, 4) + "%";
            }
             zzbzStaffDuty = zzbzMapper.getStaffDuty(depCode);
            redisTemplate.opsForValue().set(vuejx + "getStaffDuty:" + tempdep, zzbzStaffDuty);
        }


        return zzbzStaffDuty;
    }

    @Override
    public ZzbzGeneralUse getGeneralUse(String depCode) {
        String tempdep = depCode;
        ZzbzGeneralUse zzbzGeneralUse = null;
        Object o = redisTemplate.opsForValue().get(vuejx + "getGeneralUse:" + depCode);
        if (o != null) {
            zzbzGeneralUse = (ZzbzGeneralUse) o;
        } else {
            if (!"36%".equals(depCode)) {
                depCode = depCode.substring(0, 4) + "%";
            }
             zzbzGeneralUse = zzbzMapper.getGeneralUse(depCode);
            redisTemplate.opsForValue().set(vuejx + "getGeneralUse:" + tempdep, zzbzGeneralUse);
        }
        return zzbzGeneralUse;
    }

    @Override
    public List<ZzbzRecycle> getRecycle(String depCode) {
        String tempdep = depCode;
        List<ZzbzRecycle> zzbzRecycleList = null;
        Object o = redisTemplate.opsForValue().get(vuejx + "getRecycle:" + depCode);
        if (o != null) {
            zzbzRecycleList = (List<ZzbzRecycle>) o;
        } else {
            if (!"36%".equals(depCode)) {
                depCode = depCode.substring(0, 4) + "%";
            }
            zzbzRecycleList = zzbzMapper.getRecycle(depCode);
            redisTemplate.opsForValue().set(vuejx + "getRecycle:" + tempdep, zzbzRecycleList);
        }

        return zzbzRecycleList;
    }

    @Override
    public ZzbzRetire getRetire(String depCode) {
        String tempdep = depCode;
        ZzbzRetire retire = null;
        Object o = redisTemplate.opsForValue().get(vuejx + "getRetire:" + depCode);
        if (o != null) {
            retire = (ZzbzRetire) o;
        } else {
            if (!"36%".equals(depCode)) {
                depCode = depCode.substring(0, 4) + "%";
            }
             retire = zzbzMapper.getRetire(depCode);
            redisTemplate.opsForValue().set(vuejx + "getRetire:" + tempdep, retire == null ? new ZzbzRetire() : retire);
        }

        return retire == null ? new ZzbzRetire() : retire;
    }


}
