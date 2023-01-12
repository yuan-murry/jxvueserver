package com.gxzh.jxvueserver.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Cbz implements Serializable {

    private static final long serialVersionUID = 1615855338739481469L;
    private String desp;
    private String disOrder;
    private int chaobz;
    private int chaozs;
    private int chaojg;
}
