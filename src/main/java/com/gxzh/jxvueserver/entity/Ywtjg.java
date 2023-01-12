package com.gxzh.jxvueserver.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Ywtjg implements Serializable {


    private static final long serialVersionUID = -6113301623121527682L;
    private String desp;
    private String jgsyName;
    private String wt;

}
