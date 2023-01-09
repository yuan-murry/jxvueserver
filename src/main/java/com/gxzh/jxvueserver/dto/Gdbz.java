package com.gxzh.jxvueserver.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Gdbz implements Serializable {
    private static final long serialVersionUID = 768357221607804301L;
    private String desp;
    private Integer dzqBz = 0;
    private Integer dzqZz = 0;
    private Integer syBz = 0;
    private Integer syZz = 0;
    private Integer sykbsXz = 0;
    private Integer sykbsSy = 0;
    private Integer xzDfp = 0;
    private Integer syDfp = 0;
}
