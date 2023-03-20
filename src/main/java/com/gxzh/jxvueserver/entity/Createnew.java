package com.gxzh.jxvueserver.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Createnew implements Serializable {
    private static final long serialVersionUID = -4873446975519335817L;

    private int num1;
    private int num2;
    private int num3;
    private int num4;

}
