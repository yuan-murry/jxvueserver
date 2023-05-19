package com.gxzh.jxvueserver.service.impl;

import com.gxzh.jxvueserver.dto.*;
import com.gxzh.jxvueserver.mapper.HomeMapper;
import com.gxzh.jxvueserver.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeMapper homeMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    private final String vuejx = "vuejx:home:";

    @Override
    public SydwPie selectSydwpie(String depCode) {
        //先请求redis
        Object o = redisTemplate.opsForValue().get(vuejx + "sydwpie:" + depCode);
        SydwPie sydwPie = null;
        if (o != null) {
            sydwPie = (SydwPie) o;
        } else {
            sydwPie = homeMapper.selectSydwpie(depCode);
            if (sydwPie == null) {
                sydwPie = new SydwPie();

            }
            redisTemplate.opsForValue().set(vuejx + "sydwpie:" + depCode, sydwPie);
        }
        return sydwPie;
    }

    @Override
    public XzjgPie selectXzjgpie(String depCode) {
        //先请求redis
        Object o = redisTemplate.opsForValue().get(vuejx + "xzjgpie:" + depCode);
        XzjgPie xzjgPie = null;
        if (o != null) {
            xzjgPie = (XzjgPie) o;
        } else {
            xzjgPie = homeMapper.selectXzjgpie(depCode);
            if (xzjgPie == null) {
                xzjgPie = new XzjgPie();
            }
            redisTemplate.opsForValue().set(vuejx + "xzjgpie:" + depCode, xzjgPie);
        }
        return xzjgPie;
    }

    @Override
    public Bzqk selectBzqk(String depCode) {
        //先请求redis
        Object o = redisTemplate.opsForValue().get(vuejx + "bzqk:" + depCode);
        Bzqk bzqk = null;
        if (o != null) {
            bzqk = (Bzqk) o;
        } else {
            bzqk = homeMapper.selectBzqk(depCode);
            if (bzqk == null) {
                bzqk = new Bzqk();
            }
            redisTemplate.opsForValue().set(vuejx + "bzqk:" + depCode, bzqk);
        }
        return bzqk;
    }

    @Override
    public Ldzs selectXzLdzs(String depCode) {
        //先请求redis
        Object o = redisTemplate.opsForValue().get(vuejx + "xzldzs:" + depCode);
        Ldzs ldzs = null;
        if (o != null) {
            ldzs = (Ldzs) o;
        } else {
            ldzs = homeMapper.selectXzLdzs(depCode);
            if (ldzs == null) {
                ldzs = new Ldzs();
            }
            redisTemplate.opsForValue().set(vuejx + "xzldzs:" + depCode, ldzs);
        }
        return ldzs;
    }

    @Override
    public Ldzs selectSyLdzs(String depCode) {
        //先请求redis
        Object o = redisTemplate.opsForValue().get(vuejx + "syldzs:" + depCode);
        Ldzs ldzs = null;
        if (o != null) {
            ldzs = (Ldzs) o;
        } else {
            ldzs = homeMapper.selectSyLdzs(depCode);
            if (ldzs == null) {
                ldzs = new Ldzs();
            }
            redisTemplate.opsForValue().set(vuejx + "syldzs:" + depCode, ldzs);
        }
        return ldzs;
    }

    @Override
    public String testbase() {
        return homeMapper.testbase();
    }

    @Override
    public GeoSituation getGeoSituation(String depCode) {
        if("36%".equals(depCode)){
            depCode = "36____";
        }else if(depCode.contains("%")){
            depCode = depCode.substring(0,depCode.length()-1)+"00";
        }
        return homeMapper.getGeoSituation(depCode);
    }





   public List<XzjgLdzsChild> selectXzjgLdzsChild(String depCode, String ldzstype){
       Object o = redisTemplate.opsForValue().get(vuejx + "xzjgLdzsChild:" + depCode+ldzstype);
       List<XzjgLdzsChild> xzjgLdzsChildList = null;
       if (o != null) {
           xzjgLdzsChildList = (List<XzjgLdzsChild>) o;
       } else {

           xzjgLdzsChildList = homeMapper.selectXzjgLdzsChild(depCode,ldzstype);
           if (xzjgLdzsChildList == null) {
               xzjgLdzsChildList = new ArrayList<>();
           }
           redisTemplate.opsForValue().set(vuejx + "xzjgLdzsChild:" + depCode+ldzstype, xzjgLdzsChildList);
       }
       return xzjgLdzsChildList;
   }

    public List<SyjgLdzsChild> selectSyjgLdzsChild(String depCode, String ldzstype){
        Object o = redisTemplate.opsForValue().get(vuejx + "syjgLdzsChild:" + depCode+ldzstype);
        List<SyjgLdzsChild> syjgLdzsChildList = null;
        if (o != null) {
            syjgLdzsChildList = (List<SyjgLdzsChild>) o;
        } else {

            syjgLdzsChildList = homeMapper.selectSyjgLdzsChild(depCode,ldzstype);
            if (syjgLdzsChildList == null) {
                syjgLdzsChildList = new ArrayList<>();
            }
            redisTemplate.opsForValue().set(vuejx + "syjgLdzsChild:" + depCode+ldzstype, syjgLdzsChildList);
        }
        return syjgLdzsChildList;
    }
}
