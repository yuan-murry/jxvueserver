package com.gxzh.jxvueserver.service;

import com.github.pagehelper.PageInfo;
import com.gxzh.jxvueserver.dto.*;

public interface HomeService {
    SydwPie selectSydwpie(String depCode);

    XzjgPie selectXzjgpie(String depCode);

    Bzqk selectBzqk(String depCode);

    Ldzs selectXzLdzs(String depCode);

    Ldzs selectSyLdzs(String depCode);

    String testbase();

    GeoSituation getGeoSituation(String depCode);

    PageInfo<XzjgLdzsChild> selectXzjgLdzsChild(String depCode, String ldzstype, int pageNum, int pageSize);

    PageInfo<SyjgLdzsChild>  selectSyjgLdzsChild(String depCode,String ldzstype,int pageNum, int pageSize);

    PageInfo<XzjgPieChild>  selectXzjgPieChild(String depCode,String depName,int pageNum,int pageSize);
    PageInfo<SydwPieChild>  selectSydwPieChild(String depCode,String depName,int pageNum,int pageSize);

    PageInfo<XzjgLdzsChildDetail>  selectXzjgLdzsChildDetail(String depCode,String doquery,int pageNum,int pageSize);

    PageInfo<SydwLdzsChildDetail>  selectSydwLdzsChildDetail(String depCode,String doquery,int pageNum,int pageSize);

    PageInfo<Bzqk_fc> selectBzqk_fc(String depCode ,String type,int pageNum,int pageSize);

    PageInfo<Bzqk_fc_sy> selectBzqk_sy(String depCode ,String type,int pageNum,int pageSize);

    PageInfo<XzjgBzsChildDfp> getXzjgBzsChildDfp(String depCode,int pageNum,int pageSize);

    PageInfo<SydwBzsChildDfp> getSydwBzsChildDfp(String depCode,int pageNum,int pageSize);

    PageInfo<Dzq_fc> selectDzq_fc(String depCode ,String type,int pageNum,int pageSize);

    PageInfo<Zf_fc> selectZf_fc(String depCode ,String type,int pageNum,int pageSize);

    PageInfo<DzqChildDfp> getDzqChildDfp(String depCode,int pageNum,int pageSize);

    PageInfo<ZfChildDfp> getZfChildDfp(String depCode,int pageNum,int pageSize);
}
