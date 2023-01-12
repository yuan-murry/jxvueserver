package com.gxzh.jxvueserver.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Ywlx implements Serializable {

    private static final long serialVersionUID = -1843983105824023248L;
    private String name;
    private int value;
}
