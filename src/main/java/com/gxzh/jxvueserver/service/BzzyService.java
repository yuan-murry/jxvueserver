package com.gxzh.jxvueserver.service;

import com.github.pagehelper.PageInfo;
import com.gxzh.jxvueserver.dto.*;

import java.util.List;

public interface BzzyService {

    List<Gdbz> getXzbzpie(String depCode);

    List<BzzyLdzs> getLdzspie(String depCode);

    BzzyBzlx getBzzyBzlx(String depCode);

    List<BzzyNoUse> getNoUse(String depCode);

    List<BzzyRetire> getRetire(String depCode);

    List<BzzyIndstry> getInsdstry(String depCode);

    List<BzzyIndstry> getInsdstryChild(String depCode, String flCode);

    PageInfo<BzlxChild>  getBzzyBzlxChild(String bzType, String depCode,int pageNum, int pageSize);

    PageInfo<JfxsChild>  getBzzyJfxsChild(String bzType, String depCode,int pageNum, int pageSize);
}
