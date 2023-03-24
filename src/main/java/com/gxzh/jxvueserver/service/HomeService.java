package com.gxzh.jxvueserver.service;

import com.gxzh.jxvueserver.dto.*;

public interface HomeService {
    SydwPie selectSydwpie(String depCode);

    XzjgPie selectXzjgpie(String depCode);

    Bzqk selectBzqk(String depCode);

    Ldzs selectXzLdzs(String depCode);

    Ldzs selectSyLdzs(String depCode);

    String testbase();

    GeoSituation getGeoSituation(String depCode);


}
