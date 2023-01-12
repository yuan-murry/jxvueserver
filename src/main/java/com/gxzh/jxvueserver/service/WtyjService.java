package com.gxzh.jxvueserver.service;

import com.gxzh.jxvueserver.entity.Cbz;
import com.gxzh.jxvueserver.entity.Ywtjg;

import java.util.List;

public interface WtyjService {

    List<Cbz> selectCbz(String depcode);
    List<Ywtjg> selectYwtjg(String depcode);
}
