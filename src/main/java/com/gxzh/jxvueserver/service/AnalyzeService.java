package com.gxzh.jxvueserver.service;

import com.github.pagehelper.PageInfo;
import com.gxzh.jxvueserver.dto.AreaBusinessChild;
import com.gxzh.jxvueserver.dto.YwlxChild;
import com.gxzh.jxvueserver.entity.*;

import java.util.List;

public interface AnalyzeService {

    List<Ywlx> selectYwlx(String depcode);
    List<Nywbl> selectNywbl(String depcode);
    List<Yywbl> selectYywbl(String depcode);
    List<Gdyw> selectGdyw(String depcode);
    List<Jryw> selectJryw(String depcode);
    AreaBusinessChild getAreaBusinessChild(String depName);
    PageInfo<YwlxChild> selectYwlxChild(String depCode, String codeValue, int pageNum, int pageSize);
}



