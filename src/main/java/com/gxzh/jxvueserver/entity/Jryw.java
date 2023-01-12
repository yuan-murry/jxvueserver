package com.gxzh.jxvueserver.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Jryw implements Serializable {

    private static final long serialVersionUID = 5765003253437639685L;
    private String jgsyName;
    private int kbs;
    private String today;


}
