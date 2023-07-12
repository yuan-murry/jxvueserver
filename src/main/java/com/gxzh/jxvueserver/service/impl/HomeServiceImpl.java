package com.gxzh.jxvueserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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





   public PageInfo<XzjgLdzsChild> selectXzjgLdzsChild(String depCode, String ldzstype ,int pageNum, int pageSize){

       List<XzjgLdzsChild> xzjgLdzsChildList = null;

            PageHelper.startPage(pageNum,pageSize);
           xzjgLdzsChildList = homeMapper.selectXzjgLdzsChild(depCode,ldzstype);
           if(xzjgLdzsChildList==null){
               xzjgLdzsChildList=new ArrayList<>();
           }
           PageInfo<XzjgLdzsChild> pageList=new PageInfo<>(xzjgLdzsChildList);


       return pageList;
   }

    public PageInfo<SyjgLdzsChild> selectSyjgLdzsChild(String depCode, String ldzstype,int pageNum, int pageSize){

        List<SyjgLdzsChild> syjgLdzsChildList = null;

        PageHelper.startPage(pageNum,pageSize);
            syjgLdzsChildList = homeMapper.selectSyjgLdzsChild(depCode,ldzstype);
        if (syjgLdzsChildList == null) {
            syjgLdzsChildList = new ArrayList<>();
        }

        PageInfo<SyjgLdzsChild> pageList=new PageInfo<>(syjgLdzsChildList);


        return pageList;
    }


    public PageInfo<XzjgPieChild> selectXzjgPieChild(String depCode, String depName,int pageNum,int pageSize){
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





        List<XzjgPieChild> xzjgPieChildList = null;

            PageHelper.startPage(pageNum,pageSize);
            xzjgPieChildList = homeMapper.selectXzjgPieChild(depCode,depName);
        if (xzjgPieChildList == null) {
            xzjgPieChildList = new ArrayList<>();
        }

        PageInfo<XzjgPieChild> pageList=new PageInfo<>(xzjgPieChildList);


        return pageList;
    }

    public PageInfo<SydwPieChild> selectSydwPieChild(String depCode, String depName,int pageNum,int pageSize){
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





        List<SydwPieChild> sydwPieChildList = null;

            PageHelper.startPage(pageNum,pageSize);
            sydwPieChildList = homeMapper.selectSydwPieChild(depCode,depName);
        if (sydwPieChildList == null) {
            sydwPieChildList = new ArrayList<>();
        }

        PageInfo<SydwPieChild> pageList=new PageInfo<>(sydwPieChildList);


        return pageList;
    }


    public PageInfo<XzjgLdzsChildDetail> selectXzjgLdzsChildDetail(String depCode, String doquery,int pageNum,int pageSize){

        List<XzjgLdzsChildDetail> xzjgLdzsChildDetailList = null;

            PageHelper.startPage(pageNum,pageSize);
            xzjgLdzsChildDetailList = homeMapper.selectXzjgLdzsChildDetail(depCode,doquery);
        if (xzjgLdzsChildDetailList == null) {
            xzjgLdzsChildDetailList = new ArrayList<>();
        }
            PageInfo<XzjgLdzsChildDetail> pageList=new PageInfo<>(xzjgLdzsChildDetailList);



        return pageList;
    }

    public PageInfo<SydwLdzsChildDetail> selectSydwLdzsChildDetail(String depCode, String doquery,int pageNum,int pageSize){

        List<SydwLdzsChildDetail> sydwLdzsChildDetailList = null;

        PageHelper.startPage(pageNum,pageSize);
            sydwLdzsChildDetailList = homeMapper.selectSydwLdzsChildDetail(depCode,doquery);
        if (sydwLdzsChildDetailList == null) {
            sydwLdzsChildDetailList = new ArrayList<>();
        }
        PageInfo<SydwLdzsChildDetail> pageList=new PageInfo<>(sydwLdzsChildDetailList);



        return pageList;
    }


    @Override
    public PageInfo<Bzqk_fc> selectBzqk_fc(String depCode,String type,int pageNum,int pageSize) {

        List<Bzqk_fc> fzqk_fc = null;

            PageHelper.startPage(pageNum,pageSize);
            fzqk_fc = homeMapper.selectBzqk_fc(depCode,type);
        if (fzqk_fc == null) {
            fzqk_fc = new ArrayList<>();
        }
            PageInfo<Bzqk_fc> pageList=new PageInfo<>(fzqk_fc);



        return pageList;
    }

    @Override
    public PageInfo<Bzqk_fc_sy> selectBzqk_sy(String depCode,String type,int pageNum,int pageSize) {

        List<Bzqk_fc_sy> bzqk_fc_sy = null;

            PageHelper.startPage(pageNum,pageSize);
            bzqk_fc_sy = homeMapper.selectBzqk_sy(depCode,type);
        if (bzqk_fc_sy == null) {
            bzqk_fc_sy = new ArrayList<>();
        }

        PageInfo<Bzqk_fc_sy> pageList=new PageInfo<>(bzqk_fc_sy);


        return pageList;
    }

    @Override
    public PageInfo<XzjgBzsChildDfp> getXzjgBzsChildDfp(String depCode,int pageNum,int pageSize) {

        List<XzjgBzsChildDfp> xzjgBzsChildDfpList = null;

            PageHelper.startPage(pageNum,pageSize);
            xzjgBzsChildDfpList = homeMapper.getXzjgBzsChildDfp(depCode);
        if (xzjgBzsChildDfpList == null) {
            xzjgBzsChildDfpList = new ArrayList<>();
        }

        PageInfo<XzjgBzsChildDfp> pageList=new PageInfo<>(xzjgBzsChildDfpList);


        return pageList;
    }

    @Override
    public PageInfo<SydwBzsChildDfp> getSydwBzsChildDfp(String depCode,int pageNum,int pageSize) {

        List<SydwBzsChildDfp> sydwBzsChildDfpList = null;

            PageHelper.startPage(pageNum,pageSize);
            sydwBzsChildDfpList = homeMapper.getSydwBzsChildDfp(depCode);
        if (sydwBzsChildDfpList == null) {
            sydwBzsChildDfpList = new ArrayList<>();
        }
            PageInfo<SydwBzsChildDfp> pageList=new PageInfo<>(sydwBzsChildDfpList);



        return pageList;
    }


    @Override
    public PageInfo<Dzq_fc> selectDzq_fc(String depCode,String type,int pageNum,int pageSize) {

        List<Dzq_fc> dzqfcList = null;

            PageHelper.startPage(pageNum,pageSize);
            dzqfcList = homeMapper.selectDzq_fc(depCode,type);
        if (dzqfcList == null) {
            dzqfcList = new ArrayList<>();
        }

        PageInfo<Dzq_fc> pageList=new PageInfo<>(dzqfcList);


        return pageList;
    }

    @Override
    public PageInfo<Zf_fc> selectZf_fc(String depCode,String type,int pageNum,int pageSize) {

        List<Zf_fc> zffcList = null;

            PageHelper.startPage(pageNum,pageSize);
            zffcList = homeMapper.selectZf_fc(depCode,type);
        if (zffcList == null) {
            zffcList = new ArrayList<>();
        }
            PageInfo<Zf_fc> pageList=new PageInfo<>(zffcList);



        return pageList;
    }


    @Override
    public PageInfo<DzqChildDfp> getDzqChildDfp(String depCode,int pageNum,int pageSize) {

        List<DzqChildDfp> dzqChildDfpList = null;

            PageHelper.startPage(pageNum,pageSize);
            dzqChildDfpList = homeMapper.getDzqChildDfp(depCode);
        if (dzqChildDfpList == null) {
            dzqChildDfpList = new ArrayList<>();
        }
            PageInfo<DzqChildDfp> pageList=new PageInfo<>(dzqChildDfpList);



        return pageList;
    }


    @Override
    public PageInfo<ZfChildDfp> getZfChildDfp(String depCode,int pageNum,int pageSize) {

        List<ZfChildDfp> zfChildDfpList = null;

            PageHelper.startPage(pageNum,pageSize);
            zfChildDfpList = homeMapper.getZfChildDfp(depCode);
        if (zfChildDfpList == null) {
            zfChildDfpList = new ArrayList<>();
        }
            PageInfo<ZfChildDfp> pageList=new PageInfo<>(zfChildDfpList);



        return pageList;
    }
}
