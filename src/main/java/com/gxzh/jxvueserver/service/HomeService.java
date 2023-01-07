package com.gxzh.jxvueserver.service;

import com.gxzh.jxvueserver.dto.Bzqk;
import com.gxzh.jxvueserver.dto.Ldzs;
import com.gxzh.jxvueserver.dto.SydwPie;
import com.gxzh.jxvueserver.dto.XzjgPie;

public interface HomeService {
    SydwPie selectSydwpie(String depCode);

    XzjgPie selectXzjgpie(String depCode);

    Bzqk selectBzqk(String depCode);

    Ldzs selectXzLdzs(String depCode);

    Ldzs selectSyLdzs(String depCode);
}
