package com.gxzh.jxvueserver.mapper;

import com.gxzh.jxvueserver.dto.BzzyIndstry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HyflMapper {


    List<BzzyIndstry> getInsdstry(String depCode);


    List<BzzyIndstry> getInsdstryChild(@Param("depCode") String depCode, @Param("flCode") String flCode);


}
