package com.gxzh.jxvueserver.mapper;

import com.gxzh.jxvueserver.entity.Cbz;
import com.gxzh.jxvueserver.entity.Ywtjg;

import java.util.List;

public interface WtyjMapper {

    List<Cbz> selectCbz(String depcode, String code);
    List<Ywtjg> selectYwtjg(String depcode, String code);
}
