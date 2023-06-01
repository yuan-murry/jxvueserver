package com.gxzh.jxvueserver.service;

import com.gxzh.jxvueserver.dto.VtxPie;
import com.gxzh.jxvueserver.dto.WtyjJgsy;
import com.gxzh.jxvueserver.entity.*;

import java.util.List;

public interface WtyjService {

    List<Cbz> selectCbz(String depcode);

    List<Ywtjg> selectYwtjg(String depcode);

    List<Azwtlx> selectAzwtlx(String depcode);

    List<Azzgfs> selectAzzgfs(String depcode);

    List<Ywttz> selectYwttz(String depcode);

    List<WtyjJgsy> getextraPieChild(String depCode,String jgsyNum);

    List<WtyjJgsy> selectextraPieChildDetail(String depName,String classNum);

    List<VtxPie> selectLTX(String depcode);

}
