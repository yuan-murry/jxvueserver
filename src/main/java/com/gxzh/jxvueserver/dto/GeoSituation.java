package com.gxzh.jxvueserver.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class GeoSituation implements Serializable {
    private String depcode;
    private String desp;
    private BigDecimal area;
    private BigDecimal population;
    private BigDecimal regionalgdp;
    private BigDecimal revenue;
}
