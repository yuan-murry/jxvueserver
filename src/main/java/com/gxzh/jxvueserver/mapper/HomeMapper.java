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
}
