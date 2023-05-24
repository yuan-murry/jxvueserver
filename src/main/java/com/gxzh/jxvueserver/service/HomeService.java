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
}
