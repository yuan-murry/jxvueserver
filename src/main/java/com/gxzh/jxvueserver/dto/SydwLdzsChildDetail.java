package com.gxzh.jxvueserver.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class SydwLdzsChildDetail implements Serializable {

    private static final long serialVersionUID = -4307507392614378653L;
    private String desp;
    private String jgname;
    private String jgsySystemCode;
    private String jfxs;
    private String sydwhyfl;
    private int   ldzscount;
}
