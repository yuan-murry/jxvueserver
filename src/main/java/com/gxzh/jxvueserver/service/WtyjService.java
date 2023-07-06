package com.gxzh.jxvueserver.service;

import com.github.pagehelper.PageInfo;
import com.gxzh.jxvueserver.dto.VtxPie;
import com.gxzh.jxvueserver.dto.Vtx_fc;
import com.gxzh.jxvueserver.dto.WtyjJgsy;
import com.gxzh.jxvueserver.entity.*;

import java.util.List;

public interface WtyjService {

    List<Cbz> selectCbz(String depcode);

    List<Ywtjg> selectYwtjg(String depcode);

    List<Azwtlx> selectAzwtlx(String depcode);

    List<Azzgfs> selectAzzgfs(String depcode);

    List<Ywttz> selectYwttz(String depcode);

    PageInfo<WtyjJgsy> getextraPieChild(String depCode, String jgsyNum,int pageNum,int pageSize);

    PageInfo<WtyjJgsy> selectextraPieChildDetail(String depName,String classNum,int pageNum,int pageSize);

    List<VtxPie> selectLTX(String depcode);

    PageInfo<Vtx_fc> selectVTX_fc(String depName,  int pageNum, int pageSize);

}
