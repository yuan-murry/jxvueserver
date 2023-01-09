package com.gxzh.jxvueserver.mapper;

import com.gxzh.jxvueserver.entity.*;

import java.util.List;

public interface AnalyzeMapper {
    List<Ywlx> selectYwlx(String depcode, String code);
    List<Nywbl> selectNywbl(String depcode, String code);
    List<Yywbl> selectYywbl(String depcode, String code);
    List<Gdyw> selectGdyw(String depcode, String code);
    List<Jryw> selectJryw(String depcode, String code);

}
