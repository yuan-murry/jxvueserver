package com.gxzh.jxvueserver.service;

import com.github.pagehelper.PageInfo;
import com.gxzh.jxvueserver.dto.*;

import java.util.List;

public interface ZzbzService {
    ZzbzUseCondition getUseCondition(String depCode);

    List<ZzbzAllot> getZzbzAllot(String depCode);

    ZzbzStaffDuty getStaffDuty(String depCode);

    ZzbzGeneralUse getGeneralUse(String depCode);

    List<ZzbzRecycle> getRecycle(String depCode);

    List<ZzbzRetire> getRetire(String depCode);

    PageInfo<ZzbzDetail> selectZzbzDetail(String depCode, int pageNum, int pageSize);
}
