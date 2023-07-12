package com.gxzh.jxvueserver.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AreaBusinessChild implements Serializable {
    private static final long serialVersionUID = -5349695187666895042L;
    private String depName;
    private Integer rbrs;
    private Integer ltxrs;
}
