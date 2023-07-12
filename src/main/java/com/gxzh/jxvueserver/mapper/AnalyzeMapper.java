package com.gxzh.jxvueserver.mapper;

import com.gxzh.jxvueserver.dto.AreaBusinessChild;
import com.gxzh.jxvueserver.dto.YwlxChild;
import com.gxzh.jxvueserver.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnalyzeMapper {
    List<Ywlx> selectYwlx(String depcode, String code);
    List<Nywbl> selectNywbl(String depcode, String code);
    List<Yywbl> selectYywbl(String depcode, String code);
    List<Gdyw> selectGdyw(String depcode, String code);
    List<Jryw> selectJryw(String depcode, String code);

    AreaBusinessChild getAreaBusinessChild(@Param("depName") String depName);

    List<YwlxChild> selectYwlxChild(@Param("depCode") String depCode,@Param("codeValue") String codeValue);
}
