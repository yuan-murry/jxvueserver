package com.gxzh.jxvueserver.service.impl;

import com.gxzh.jxvueserver.dto.*;
import com.gxzh.jxvueserver.mapper.BzzyMapper;
import com.gxzh.jxvueserver.service.BzzyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BzzyServiceImpl implements BzzyService {
    @Autowired
    private BzzyMapper bzzyMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    private final String vuejx = "vuejx:bzzy:";

    @Override
    public List<Gdbz> getXzbzpie(String depCode) {
        Object o = redisTemplate.opsForValue().get(vuejx + "getXzbzpie:" + depCode);
        List<Gdbz> gdbz = null;
        if (o != null) {
            gdbz = (List<Gdbz>) o;
        } else {
            //省
            if ("36%".equals(depCode)) {
                gdbz = bzzyMapper.getXzbzpie_sheng();
            } else {
                //市县
                gdbz = bzzyMapper.getXzbzpie_shi(depCode.substring(0, 4) + "%", depCode);
            }
            redisTemplate.opsForValue().set(vuejx + "getXzbzpie:" + depCode, gdbz);
        }
        return gdbz;
    }

    @Override
    public List<BzzyLdzs> getLdzspie(String depCode) {
        List<BzzyLdzs> bzzyLdzs = null;
        Object o = redisTemplate.opsForValue().get(vuejx + "getLdzspie:" + depCode);
        if (o != null) {
            bzzyLdzs = (List<BzzyLdzs>) o;
        } else {
            if ("36%".equals(depCode)) {
                bzzyLdzs = bzzyMapper.getLdzspie_sheng();
            } else {
                bzzyLdzs = bzzyMapper.getLdzspie_shi(depCode.substring(0, 4) + "%", depCode);
            }
            redisTemplate.opsForValue().set(vuejx + "getLdzspie:" + depCode, bzzyLdzs);
        }


        return bzzyLdzs;
    }

    @Override
    public BzzyBzlx getBzzyBzlx(String depCode) {
        String tempdep = depCode;
        BzzyBzlx bzzyBzlx = null;
        Object o = redisTemplate.opsForValue().get(vuejx + "getBzzyBzlx:" + depCode);
        if (o != null) {
            bzzyBzlx = (BzzyBzlx) o;
        } else {
            if (!"36%".equals(depCode)) {
                depCode = depCode.substring(0, 4) + "%";
            }
            bzzyBzlx = bzzyMapper.getBzzyBzlx(depCode);
            redisTemplate.opsForValue().set(vuejx + "getBzzyBzlx:" + tempdep, bzzyBzlx);
        }

        return bzzyBzlx;
    }

    @Override
    public List<BzzyNoUse> getNoUse(String depCode) {
        String tempdep = depCode;
        List<BzzyNoUse> noUse = null;
        Object o = redisTemplate.opsForValue().get(vuejx + "getNoUse:" + depCode);
        if (o != null) {
            noUse = (List<BzzyNoUse>) o;
        } else {
            if (!"36%".equals(depCode)) {
                depCode = depCode.substring(0, 4) + "%";
            }
            noUse = bzzyMapper.getNoUse(depCode);
            redisTemplate.opsForValue().set(vuejx + "getNoUse:" + tempdep, noUse);
        }

        return noUse;
    }

    @Override
    public BzzyRetire getRetire(String depCode) {
        String tempdep = depCode;
        BzzyRetire retire = null;
        Object o = redisTemplate.opsForValue().get(vuejx + "getRetire:" + depCode);
        if (o != null) {
            retire = (BzzyRetire) o;
        } else {
            if (!"36%".equals(depCode)) {
                depCode = depCode.substring(0, 4) + "%";
            }
            retire = bzzyMapper.getRetire(depCode);
            redisTemplate.opsForValue().set(vuejx + "getRetire:" + tempdep, retire == null ? new BzzyRetire() : retire);
        }
        return retire == null ? new BzzyRetire() : retire;
    }

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
            insdstry = bzzyMapper.getInsdstry(depCode);
            redisTemplate.opsForValue().set(vuejx + "getInsdstry:" + depCode, insdstry);
        }

        return insdstry;
    }
}
