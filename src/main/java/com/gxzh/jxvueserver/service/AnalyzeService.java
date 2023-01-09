package com.gxzh.jxvueserver.service;

import com.gxzh.jxvueserver.entity.*;

import java.util.List;

public interface AnalyzeService {

    List<Ywlx> selectYwlx(String depcode);
    List<Nywbl> selectNywbl(String depcode);
    List<Yywbl> selectYywbl(String depcode);
    List<Gdyw> selectGdyw(String depcode);
    List<Jryw> selectJryw(String depcode);
}



