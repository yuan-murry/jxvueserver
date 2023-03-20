package com.gxzh.jxvueserver.service;

import com.gxzh.jxvueserver.entity.Createnew;

import java.util.List;

public interface CreatenewService {

    List<Createnew> selectCreatenew(String depcode);
}
