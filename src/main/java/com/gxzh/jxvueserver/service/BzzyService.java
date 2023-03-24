package com.gxzh.jxvueserver.service;

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

}
