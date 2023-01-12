package com.gxzh.jxvueserver.mapper;


import com.gxzh.jxvueserver.dto.Bzqk;
import com.gxzh.jxvueserver.dto.Ldzs;
import com.gxzh.jxvueserver.dto.SydwPie;
import com.gxzh.jxvueserver.dto.XzjgPie;
import org.apache.ibatis.annotations.Param;

public interface HomeMapper {

    SydwPie selectSydwpie(@Param("depCode") String depCode);

    XzjgPie selectXzjgpie(@Param("depCode") String depCode);

    Bzqk selectBzqk(@Param("depCode") String depCode);

    Ldzs selectXzLdzs(@Param("depCode") String depCode);

    Ldzs selectSyLdzs(@Param("depCode") String depCode);

    String testbase();

}
