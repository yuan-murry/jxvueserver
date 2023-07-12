package com.gxzh.jxvueserver.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class YwlxChild implements Serializable {
    private static final long serialVersionUID = 5324870368063414455L;
    private String desp;
    private String jgname;
    private String jgsySystemCode;
    private String jgtype;
    private String codeChinName;
    private int value;
}
