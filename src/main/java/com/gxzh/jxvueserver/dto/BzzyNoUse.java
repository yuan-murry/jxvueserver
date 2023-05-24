package com.gxzh.jxvueserver.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BzzyNoUse implements Serializable {
    private static final long serialVersionUID = -722752209897577939L;
    private String jgsyName;

    private Integer bzs = 0;
}
