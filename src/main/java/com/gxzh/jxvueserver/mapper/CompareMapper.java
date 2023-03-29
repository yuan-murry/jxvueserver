package com.gxzh.jxvueserver.mapper;

import com.gxzh.jxvueserver.entity.Ldzs;
import com.gxzh.jxvueserver.entity.Rkbz;
import com.gxzh.jxvueserver.entity.Sybzpzbd;
import com.gxzh.jxvueserver.entity.Xzbzpzbd;

import java.util.List;

public interface CompareMapper {
    List<Ldzs> selectLdzs(String depcode,String code);
    List<Xzbzpzbd> selectXzbzpzbd(String depcode, String code);
    List<Sybzpzbd> selectSybzpzbd(String depcode, String code);
    List<Rkbz> selectRkBzZb(String depcode, String code);
}
