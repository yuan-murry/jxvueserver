package com.gxzh.jxvueserver.mapper;

import com.gxzh.jxvueserver.dto.VtxPie;
import com.gxzh.jxvueserver.dto.WtyjJgsy;
import com.gxzh.jxvueserver.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WtyjMapper {

    List<Cbz> selectCbz(String depcode, String code);

    List<Ywtjg> selectYwtjg(String depcode, String code);

    List<Azwtlx> selectAzwtlx(String depcode, String code);

    List<Azzgfs> selectAzzgfs(String depcode, String code);

    List<Ywttz> selectYwttz(String depcode, String code);

    List<WtyjJgsy> getextraPieChild(@Param("depCode") String depCode,@Param("jgsyNum") String jgsyNum);

    List<WtyjJgsy> selectextraPieChildDetail(@Param("depName") String depName,@Param("classNum") String classNum);


    List<VtxPie> selectLTX(@Param("depCode")String depCode, @Param("code") String code);
}
