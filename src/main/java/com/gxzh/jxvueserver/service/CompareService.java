package com.gxzh.jxvueserver.service;

import com.gxzh.jxvueserver.entity.Ldzs;
import com.gxzh.jxvueserver.entity.Rkbz;
import com.gxzh.jxvueserver.entity.Sybzpzbd;
import com.gxzh.jxvueserver.entity.Xzbzpzbd;

import java.util.List;

public interface CompareService {
    List<Ldzs> selectLdzs(String depcode);
    List<Xzbzpzbd> selectXzbzpzbd(String depcode);
    List<Sybzpzbd> selectSybzpzbd(String depcode);
    List<Rkbz> selectRkBzZb(String depcode);
}
