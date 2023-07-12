package com.gxzh.jxvueserver.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class XzjgLdzsChildDetail implements Serializable {

    private static final long serialVersionUID = 514313049966391453L;
    private String desp;
    private String jgname;
    private String jgsySystemCode;
    private String jgtype;
    private int   ldzscount;
}
