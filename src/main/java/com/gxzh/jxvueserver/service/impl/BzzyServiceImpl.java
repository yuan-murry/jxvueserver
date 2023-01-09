package com.gxzh.jxvueserver.service.impl;

import com.gxzh.jxvueserver.dto.*;
import com.gxzh.jxvueserver.mapper.BzzyMapper;
import com.gxzh.jxvueserver.service.BzzyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BzzyServiceImpl implements BzzyService {
    @Autowired
    private BzzyMapper bzzyMapper;

    @Override
    public List<Gdbz> getXzbzpie(String depCode) {
        List<Gdbz> gdbz = null;
        //省
        if ("36%".equals(depCode)) {
            gdbz = bzzyMapper.getXzbzpie_sheng();
        } else {
            //市县
            gdbz = bzzyMapper.getXzbzpie_shi(depCode.substring(0, 4) + "%", depCode);
        }
        return gdbz;
    }

    @Override
    public List<BzzyLdzs> getLdzspie(String depCode) {
        List<BzzyLdzs> bzzyLdzs = null;
        if ("36%".equals(depCode)) {
            bzzyLdzs = bzzyMapper.getLdzspie_sheng();
        } else {
            bzzyLdzs = bzzyMapper.getLdzspie_shi(depCode.substring(0, 4) + "%", depCode);
        }
        return bzzyLdzs;
    }

    @Override
    public BzzyBzlx getBzzyBzlx(String depCode) {
        if(!"36%".equals(depCode)){
            depCode = depCode.substring(0,4)+"%";
        }
        BzzyBzlx bzzyBzlx = bzzyMapper.getBzzyBzlx(depCode);
        return bzzyBzlx;
    }

    @Override
    public List<BzzyNoUse> getNoUse(String depCode) {
        if(!"36%".equals(depCode)){
            depCode = depCode.substring(0,4)+"%";
        }
        List<BzzyNoUse> noUse = bzzyMapper.getNoUse(depCode);
        return noUse;
    }

    @Override
    public BzzyRetire getRetire(String depCode) {
        if(!"36%".equals(depCode)){
            depCode = depCode.substring(0,4)+"%";
        }
        BzzyRetire retire = bzzyMapper.getRetire(depCode);
        return retire==null?new BzzyRetire():retire;
    }

    @Override
    public List<BzzyIndstry> getInsdstry(String depCode) {
        if(!"36%".equals(depCode)){
            depCode = depCode.substring(0,4)+"%";
        }
        List<BzzyIndstry> insdstry = bzzyMapper.getInsdstry(depCode);
        return insdstry;
    }
}
