package com.gxzh.jxvueserver.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Ywttz implements Serializable {
    private static final long serialVersionUID = -4043804487591485624L;

    private String nowmonth;

    private int xzqk;

    private int xhqk;



}
