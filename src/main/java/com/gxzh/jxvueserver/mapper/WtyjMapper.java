package com.gxzh.jxvueserver.mapper;

import com.gxzh.jxvueserver.entity.Cbz;

import java.util.List;

public interface WtyjMapper {

    List<Cbz> selectCbz(String depcode, String code);
}
