package com.gxzh.jxvueserver.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BzzyBzlx implements Serializable {
    private static final long serialVersionUID = 4383383754783238370L;
    private String desc;
    private Integer dzqBz = 0;
    private Integer gaBz = 0;
    private Integer jcyBz = 0;
    private Integer fyBz = 0;
    private Integer sfBz = 0;
    private Integer qebkBz = 0;
    private Integer cebtBz = 0;
    private Integer jfzlBz = 0;
}
