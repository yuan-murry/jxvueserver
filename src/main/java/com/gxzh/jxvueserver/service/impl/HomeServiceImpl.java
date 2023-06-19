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


    public List<XzjgPieChild> selectXzjgPieChild(String depCode, String depName){
        if(depName.equals("dw")){
            depName="01";
        }else if(depName.equals("rd")){
            depName="02";
        }else if(depName.equals("zf")){
            depName="03";
        }else if(depName.equals("zx")){
            depName="04";
        }else if(depName.equals("fy")){
            depName="07";
        }else if(depName.equals("jcy")){
            depName="08";
        }else if(depName.equals("qt")){
            depName="06";
        }else if(depName.equals("mzdp")){
            depName="05";
        }




        Object o = redisTemplate.opsForValue().get(vuejx + "xzjgPieChild:" + depCode+depName);
        List<XzjgPieChild> xzjgPieChildList = null;
        if (o != null) {
            xzjgPieChildList = (List<XzjgPieChild>) o;
        } else {

            xzjgPieChildList = homeMapper.selectXzjgPieChild(depCode,depName);
            if (xzjgPieChildList == null) {
                xzjgPieChildList = new ArrayList<>();
            }
            redisTemplate.opsForValue().set(vuejx + "xzjgPieChild:" + depCode+depName, xzjgPieChildList);
        }
        return xzjgPieChildList;
    }

    public List<SydwPieChild> selectSydwPieChild(String depCode, String depName){
        if(depName.equals("dw")){
            depName="01";
        }else if(depName.equals("rd")){
            depName="02";
        }else if(depName.equals("zf")){
            depName="03";
        }else if(depName.equals("zx")){
            depName="04";
        }else if(depName.equals("fy")){
            depName="07";
        }else if(depName.equals("jcy")){
            depName="08";
        }else if(depName.equals("qt")){
            depName="06";
        }else if(depName.equals("mzdp")){
            depName="05";
        }




        Object o = redisTemplate.opsForValue().get(vuejx + "sydwPieChild:" + depCode+depName);
        List<SydwPieChild> sydwPieChildList = null;
        if (o != null) {
            sydwPieChildList = (List<SydwPieChild>) o;
        } else {

            sydwPieChildList = homeMapper.selectSydwPieChild(depCode,depName);
            if (sydwPieChildList == null) {
                sydwPieChildList = new ArrayList<>();
            }
            redisTemplate.opsForValue().set(vuejx + "sydwPieChild:" + depCode+depName, sydwPieChildList);
        }
        return sydwPieChildList;
    }


    public List<XzjgLdzsChildDetail> selectXzjgLdzsChildDetail(String depCode, String doquery){
        Object o = redisTemplate.opsForValue().get(vuejx + "xzjgLdzsChildDetail:" + depCode+doquery);
        List<XzjgLdzsChildDetail> xzjgLdzsChildDetailList = null;
        if (o != null) {
            xzjgLdzsChildDetailList = (List<XzjgLdzsChildDetail>) o;
        } else {

            xzjgLdzsChildDetailList = homeMapper.selectXzjgLdzsChildDetail(depCode,doquery);
            if (xzjgLdzsChildDetailList == null) {
                xzjgLdzsChildDetailList = new ArrayList<>();
            }
            redisTemplate.opsForValue().set(vuejx + "xzjgLdzsChildDetail:" + depCode+doquery, xzjgLdzsChildDetailList);
        }
        return xzjgLdzsChildDetailList;
    }

    public List<SydwLdzsChildDetail> selectSydwLdzsChildDetail(String depCode, String doquery){
        Object o = redisTemplate.opsForValue().get(vuejx + "sydwLdzsChildDetail:" + depCode+doquery);
        List<SydwLdzsChildDetail> sydwLdzsChildDetailList = null;
        if (o != null) {
            sydwLdzsChildDetailList = (List<SydwLdzsChildDetail>) o;
        } else {

            sydwLdzsChildDetailList = homeMapper.selectSydwLdzsChildDetail(depCode,doquery);
            if (sydwLdzsChildDetailList == null) {
                sydwLdzsChildDetailList = new ArrayList<>();
            }
            redisTemplate.opsForValue().set(vuejx + "sydwLdzsChildDetail:" + depCode+doquery, sydwLdzsChildDetailList);
        }
        return sydwLdzsChildDetailList;
    }


    @Override
    public List<Bzqk_fc> selectBzqk_fc(String depCode,String type) {
        Object o = redisTemplate.opsForValue().get(vuejx + "fzqk_fc:" + depCode+type);
        List<Bzqk_fc> fzqk_fc = null;
        if (o != null) {
            fzqk_fc = (List<Bzqk_fc>) o;
        } else {

            fzqk_fc = homeMapper.selectBzqk_fc(depCode,type);
            if (fzqk_fc == null) {
                fzqk_fc = new ArrayList<>();
            }
            redisTemplate.opsForValue().set(vuejx + "fzqk_fc:" + depCode+type, fzqk_fc);
        }
        return fzqk_fc;
    }

    @Override
    public List<Bzqk_fc_sy> selectBzqk_sy(String depCode,String type) {
        Object o = redisTemplate.opsForValue().get(vuejx + "selectBzqk_sy:" + depCode+type);
        List<Bzqk_fc_sy> bzqk_fc_sy = null;
        if (o != null) {
            bzqk_fc_sy = (List<Bzqk_fc_sy>) o;
        } else {

            bzqk_fc_sy = homeMapper.selectBzqk_sy(depCode,type);
            if (bzqk_fc_sy == null) {
                bzqk_fc_sy = new ArrayList<>();
            }
            redisTemplate.opsForValue().set(vuejx + "selectBzqk_sy:" + depCode+type, bzqk_fc_sy);
        }
        return bzqk_fc_sy;
    }

    @Override
    public List<XzjgBzsChildDfp> getXzjgBzsChildDfp(String depCode) {
        Object o = redisTemplate.opsForValue().get(vuejx + "getXzjgBzsChildDfp:" + depCode);
        List<XzjgBzsChildDfp> xzjgBzsChildDfpList = null;
        if (o != null) {
            xzjgBzsChildDfpList = (List<XzjgBzsChildDfp>) o;
        } else {

            xzjgBzsChildDfpList = homeMapper.getXzjgBzsChildDfp(depCode);
            if (xzjgBzsChildDfpList == null) {
                xzjgBzsChildDfpList = new ArrayList<>();
            }
            redisTemplate.opsForValue().set(vuejx + "getXzjgBzsChildDfp:" + depCode, xzjgBzsChildDfpList);
        }
        return xzjgBzsChildDfpList;
    }

    @Override
    public List<SydwBzsChildDfp> getSydwBzsChildDfp(String depCode) {
        Object o = redisTemplate.opsForValue().get(vuejx + "getSydwBzsChildDfp:" + depCode);
        List<SydwBzsChildDfp> sydwBzsChildDfpList = null;
        if (o != null) {
            sydwBzsChildDfpList = (List<SydwBzsChildDfp>) o;
        } else {

            sydwBzsChildDfpList = homeMapper.getSydwBzsChildDfp(depCode);
            if (sydwBzsChildDfpList == null) {
                sydwBzsChildDfpList = new ArrayList<>();
            }
            redisTemplate.opsForValue().set(vuejx + "getSydwBzsChildDfp:" + depCode, sydwBzsChildDfpList);
        }
        return sydwBzsChildDfpList;
    }


    @Override
    public List<Dzq_fc> selectDzq_fc(String depCode,String type) {
        Object o = redisTemplate.opsForValue().get(vuejx + "selectDzq_fc:" + depCode+type);
        List<Dzq_fc> dzqfcList = null;
        if (o != null) {
            dzqfcList = (List<Dzq_fc>) o;
        } else {

            dzqfcList = homeMapper.selectDzq_fc(depCode,type);
            if (dzqfcList == null) {
                dzqfcList = new ArrayList<>();
            }
            redisTemplate.opsForValue().set(vuejx + "selectDzq_fc:" + depCode+type, dzqfcList);
        }
        return dzqfcList;
    }

    @Override
    public List<Zf_fc> selectZf_fc(String depCode,String type) {
        Object o = redisTemplate.opsForValue().get(vuejx + "selectZf_fc:" + depCode+type);
        List<Zf_fc> zffcList = null;
        if (o != null) {
            zffcList = (List<Zf_fc>) o;
        } else {

            zffcList = homeMapper.selectZf_fc(depCode,type);
            if (zffcList == null) {
                zffcList = new ArrayList<>();
            }
            redisTemplate.opsForValue().set(vuejx + "selectZf_fc:" + depCode+type, zffcList);
        }
        return zffcList;
    }


    @Override
    public List<DzqChildDfp> getDzqChildDfp(String depCode) {
        Object o = redisTemplate.opsForValue().get(vuejx + "getDzqChildDfp:" + depCode);
        List<DzqChildDfp> dzqChildDfpList = null;
        if (o != null) {
            dzqChildDfpList = (List<DzqChildDfp>) o;
        } else {

            dzqChildDfpList = homeMapper.getDzqChildDfp(depCode);
            if (dzqChildDfpList == null) {
                dzqChildDfpList = new ArrayList<>();
            }
            redisTemplate.opsForValue().set(vuejx + "getDzqChildDfp:" + depCode, dzqChildDfpList);
        }
        return dzqChildDfpList;
    }


    @Override
    public List<ZfChildDfp> getZfChildDfp(String depCode) {
        Object o = redisTemplate.opsForValue().get(vuejx + "getZfChildDfp:" + depCode);
        List<ZfChildDfp> zfChildDfpList = null;
        if (o != null) {
            zfChildDfpList = (List<ZfChildDfp>) o;
        } else {

            zfChildDfpList = homeMapper.getZfChildDfp(depCode);
            if (zfChildDfpList == null) {
                zfChildDfpList = new ArrayList<>();
            }
            redisTemplate.opsForValue().set(vuejx + "getZfChildDfp:" + depCode, zfChildDfpList);
        }
        return zfChildDfpList;
    }
}
