package com.gxzh.jxvueserver.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Ldzs implements Serializable {

    private static final long serialVersionUID = 6109412544610514971L;
    private String code;

    private String desp;

    private String disOrder;

    private int xzbz;

    private int xzpbz;

    private int sybz;

    private int sypbz;


}
