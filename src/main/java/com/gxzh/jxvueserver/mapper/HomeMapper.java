package com.gxzh.jxvueserver.mapper;


import com.gxzh.jxvueserver.dto.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeMapper {

    SydwPie selectSydwpie(@Param("depCode") String depCode);

    XzjgPie selectXzjgpie(@Param("depCode") String depCode);

    Bzqk selectBzqk(@Param("depCode") String depCode);

    Ldzs selectXzLdzs(@Param("depCode") String depCode);

    Ldzs selectSyLdzs(@Param("depCode") String depCode);

    String testbase();

    GeoSituation getGeoSituation(@Param("depCode") String depCode);

    List<XzjgLdzsChild> selectXzjgLdzsChild(@Param("depCode") String depCode, @Param("ldzstype") String ldzstype);
    List<SyjgLdzsChild> selectSyjgLdzsChild(@Param("depCode") String depCode, @Param("ldzstype") String ldzstype);

    List<XzjgPieChild> selectXzjgPieChild(@Param("depCode") String depCode, @Param("depName") String depName);

    List<SydwPieChild> selectSydwPieChild(@Param("depCode") String depCode, @Param("depName") String depName);

    List<XzjgLdzsChildDetail> selectXzjgLdzsChildDetail(@Param("depCode") String depCode, @Param("doquery") String doquery);

    List<SydwLdzsChildDetail> selectSydwLdzsChildDetail(@Param("depCode") String depCode, @Param("doquery") String doquery);

    List <Bzqk_fc> selectBzqk_fc(@Param("depCode") String depCode, @Param("type") String type);

    List <Bzqk_fc_sy> selectBzqk_sy(@Param("depCode") String depCode, @Param("type") String type);

    List <XzjgBzsChildDfp> getXzjgBzsChildDfp(@Param("depCode") String depCode);

    List <SydwBzsChildDfp> getSydwBzsChildDfp(@Param("depCode") String depCode);

    List <Dzq_fc> selectDzq_fc(@Param("depCode") String depCode, @Param("type") String type);

    List <Zf_fc> selectZf_fc(@Param("depCode") String depCode, @Param("type") String type);

    List <DzqChildDfp> getDzqChildDfp(@Param("depCode") String depCode);

    List <ZfChildDfp> getZfChildDfp(@Param("depCode") String depCode);
}
