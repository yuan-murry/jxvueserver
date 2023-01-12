package com.gxzh.jxvueserver.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Nywbl implements Serializable {
    private static final long serialVersionUID = -864111920312097885L;
    private String nowmonth;
    private int bls;
}
