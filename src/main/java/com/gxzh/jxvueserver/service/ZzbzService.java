package com.gxzh.jxvueserver.service;

import com.gxzh.jxvueserver.dto.*;

import java.util.List;

public interface ZzbzService {
    ZzbzUseCondition getUseCondition(String depCode);

    List<ZzbzAllot> getZzbzAllot(String depCode);

    ZzbzStaffDuty getStaffDuty(String depCode);

    ZzbzGeneralUse getGeneralUse(String depCode);

    List<ZzbzRecycle> getRecycle(String depCode);

    ZzbzRetire getRetire(String depCode);
}
