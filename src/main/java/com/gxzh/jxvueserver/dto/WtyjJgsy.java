package com.gxzh.jxvueserver.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class WtyjJgsy implements Serializable {
    private String jgsyName;
    private String depName;
    private String jgsyType;
    private Integer problemNum;

}
