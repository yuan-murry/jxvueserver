package com.gxzh.jxvueserver.service;

import com.gxzh.jxvueserver.dto.BzzyIndstry;

import java.util.List;

public interface HyflService {

    List<BzzyIndstry> getInsdstry(String depCode);

    List<BzzyIndstry> getInsdstryChild(String depCode, String flCode);
}
