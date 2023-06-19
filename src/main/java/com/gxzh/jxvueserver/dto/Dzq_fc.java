package com.gxzh.jxvueserver.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Dzq_fc implements Serializable {
    private static final long serialVersionUID = -7711604769437066564L;
    private String desp;
    private String jgname ;
    private String jgsySystemCode;
    private String jgtype;
    private Integer bzsy;
}
