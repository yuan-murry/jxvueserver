package com.gxzh.jxvueserver.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Yywbl implements Serializable {
    private static final long serialVersionUID = 1115584823357056817L;
    private String day;
    private int bls;
}
