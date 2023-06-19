package com.gxzh.jxvueserver.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Zf_fc implements Serializable {
    private static final long serialVersionUID = 1535908972440418898L;
    private String desp;
    private String jgname ;
    private String jgsySystemCode;
    private String jgtype;
    private Integer ga;
    private Integer jcy;
    private Integer fy;
    private Integer sf;
}
