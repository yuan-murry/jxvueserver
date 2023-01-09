package com.gxzh.jxvueserver.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ZzbzAllot implements Serializable {
    private static final long serialVersionUID = 6502233888796902399L;
    private String desp;
    private Integer bzzl = 0;
    private Integer zzkbs = 0;
    private Integer zzkbzzs = 0;
}
