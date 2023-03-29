package com.gxzh.jxvueserver.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Rkbz implements Serializable {
    private static final long serialVersionUID = -4037034174914434824L;


    private String code;

    private String desp;

    private String disOrder;

    private int population;

    private int xzbz;

    private int sybz;

}
