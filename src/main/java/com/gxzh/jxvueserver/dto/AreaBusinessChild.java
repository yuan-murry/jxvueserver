package com.gxzh.jxvueserver.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AreaBusinessChild implements Serializable {
    private String depName;
    private Integer rbrs;
    private Integer ltxrs;
}
