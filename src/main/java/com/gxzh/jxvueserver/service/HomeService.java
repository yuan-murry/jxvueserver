package com.gxzh.jxvueserver.service;

import com.gxzh.jxvueserver.dto.*;

import java.util.List;

public interface HomeService {
    SydwPie selectSydwpie(String depCode);

    XzjgPie selectXzjgpie(String depCode);

    Bzqk selectBzqk(String depCode);

    Ldzs selectXzLdzs(String depCode);

    Ldzs selectSyLdzs(String depCode);

    String testbase();

    GeoSituation getGeoSituation(String depCode);

    List<XzjgLdzsChild>  selectXzjgLdzsChild(String depCode,String ldzstype);

    List<SyjgLdzsChild>  selectSyjgLdzsChild(String depCode,String ldzstype);

    List<XzjgPieChild>  selectXzjgPieChild(String depCode,String depName);
    List<SydwPieChild>  selectSydwPieChild(String depCode,String depName);

    List<XzjgLdzsChildDetail>  selectXzjgLdzsChildDetail(String depCode,String doquery);

    List<SydwLdzsChildDetail>  selectSydwLdzsChildDetail(String depCode,String doquery);

    List<Bzqk_fc> selectBzqk_fc(String depCode ,String type);

    List<Bzqk_fc_sy> selectBzqk_sy(String depCode ,String type);

    List<XzjgBzsChildDfp> getXzjgBzsChildDfp(String depCode);

    List<SydwBzsChildDfp> getSydwBzsChildDfp(String depCode);

    List<Dzq_fc> selectDzq_fc(String depCode ,String type);

    List<Zf_fc> selectZf_fc(String depCode ,String type);

    List<DzqChildDfp> getDzqChildDfp(String depCode);

    List<ZfChildDfp> getZfChildDfp(String depCode);
}
