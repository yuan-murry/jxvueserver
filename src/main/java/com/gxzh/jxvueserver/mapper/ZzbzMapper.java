package com.gxzh.jxvueserver.mapper;

import com.gxzh.jxvueserver.dto.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZzbzMapper {

    ZzbzUseCondition getUseCondition(String depCode);

    List<ZzbzAllot> getZzbzAllot_sheng();

    List<ZzbzAllot> getZzbzAllot_shi(@Param("depCode") String depCode,@Param("allCode") String allCode);

    ZzbzStaffDuty getStaffDuty(@Param("depCode") String depCode);

    ZzbzGeneralUse getGeneralUse(String depCode);

    List<ZzbzRecycle> getRecycle(String depCode);

    List<ZzbzRetire> getRetire(String depCode);

    List<ZzbzDetail> selectZzbzDetail(@Param("depCode")String depCode);
}
