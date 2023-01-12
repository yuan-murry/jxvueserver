package com.gxzh.jxvueserver.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Sybzpzbd implements Serializable {

    private static final long serialVersionUID = 3474001754761975558L;
    private String desp;
    private String disOrder;
    private int jybz;
    private int kybz;
    private int whbz;
    private int wsbz;
    private int nlmsbz;
    private int jtbz;
    private int qtbz;

}
