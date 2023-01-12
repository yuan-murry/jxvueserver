package com.gxzh.jxvueserver.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Gdyw implements Serializable {

    private static final long serialVersionUID = 7197595747373574687L;
    private String desp;
    private String disOrder;
    private String bls;


}
