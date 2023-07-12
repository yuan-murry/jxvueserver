package com.gxzh.jxvueserver.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BzlxChild implements Serializable {


    private static final long serialVersionUID = 4879097750105457957L;
    private String desp;
    private String jgname;
    private String jgsySystemCode;
    private String jgtype;
    private int bz;
}
