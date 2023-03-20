package com.gxzh.jxvueserver.mapper;

import com.gxzh.jxvueserver.dto.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BzzyMapper {
    List<Gdbz> getXzbzpie_sheng();

    List<Gdbz> getXzbzpie_shi(@Param("depCode") String depCode,@Param("allCode") String allCode);

    List<BzzyLdzs> getLdzspie_sheng();

    List<BzzyLdzs> getLdzspie_shi(@Param("depCode") String depCode,@Param("allCode") String allCode);

    BzzyBzlx getBzzyBzlx(@Param("depCode") String depCode);


    List<BzzyNoUse> getNoUse(String depCode);

    List<BzzyRetire> getRetire(String depCode);

    List<BzzyIndstry> getInsdstry(String depCode);
}
