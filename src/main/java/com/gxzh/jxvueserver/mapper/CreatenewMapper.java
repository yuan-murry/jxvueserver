package com.gxzh.jxvueserver.mapper;

import com.gxzh.jxvueserver.entity.Createnew;

import java.util.List;

public interface CreatenewMapper {
    List<Createnew> selectCreatenew(String depcode, String code);
}
