package com.gxzh.jxvueserver.service.impl;

import com.gxzh.jxvueserver.dto.*;
import com.gxzh.jxvueserver.mapper.ZzbzMapper;
import com.gxzh.jxvueserver.service.ZzbzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZzbzServiceImpl implements ZzbzService {
    @Autowired
    private ZzbzMapper zzbzMapper;

    @Override
    public ZzbzUseCondition getUseCondition(String depCode) {
        if (!"36%".equals(depCode)) {
            depCode = depCode.substring(0, 4) + "%";
        }
        ZzbzUseCondition zzbzUseCondition = zzbzMapper.getUseCondition(depCode);
        return zzbzUseCondition;
    }

    @Override
    public List<ZzbzAllot> getZzbzAllot(String depCode) {
        List<ZzbzAllot> zzbzAllotList = null;
        if ("36%".equals(depCode)) {
            zzbzAllotList = zzbzMapper.getZzbzAllot_sheng();
        } else {
            zzbzAllotList = zzbzMapper.getZzbzAllot_shi(depCode.substring(0,4)+"%",depCode);
        }
        return zzbzAllotList;
    }

    @Override
    public ZzbzStaffDuty getStaffDuty(String depCode) {
        if (!"36%".equals(depCode)) {
            depCode = depCode.substring(0, 4) + "%";
        }
        ZzbzStaffDuty zzbzStaffDuty = zzbzMapper.getStaffDuty(depCode);
        return zzbzStaffDuty;
    }

    @Override
    public ZzbzGeneralUse getGeneralUse(String depCode) {
        if (!"36%".equals(depCode)) {
            depCode = depCode.substring(0, 4) + "%";
        }
        ZzbzGeneralUse zzbzGeneralUse =  zzbzMapper.getGeneralUse(depCode);
        return zzbzGeneralUse;
    }

    @Override
    public List<ZzbzRecycle> getRecycle(String depCode) {
        if (!"36%".equals(depCode)) {
            depCode = depCode.substring(0, 4) + "%";
        }
        List<ZzbzRecycle> zzbzRecycleList = zzbzMapper.getRecycle(depCode);
        return zzbzRecycleList;
    }

    @Override
    public ZzbzRetire getRetire(String depCode) {
        if(!"36%".equals(depCode)){
            depCode = depCode.substring(0,4)+"%";
        }
        ZzbzRetire retire = zzbzMapper.getRetire(depCode);
        return retire==null?new ZzbzRetire():retire;
    }


}
