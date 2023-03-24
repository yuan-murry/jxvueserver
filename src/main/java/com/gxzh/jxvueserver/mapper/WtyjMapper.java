package com.gxzh.jxvueserver.mapper;

import com.gxzh.jxvueserver.dto.WtyjJgsy;
import com.gxzh.jxvueserver.entity.Cbz;
import com.gxzh.jxvueserver.entity.Ywtjg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WtyjMapper {

    List<Cbz> selectCbz(String depcode, String code);

    List<Ywtjg> selectYwtjg(String depcode, String code);

    List<WtyjJgsy> getextraPieChild(@Param("depCode") String depCode,@Param("jgsyNum") String jgsyNum);
}
