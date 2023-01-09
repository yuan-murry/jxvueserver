package com.gxzh.jxvueserver.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BzzyLdzs implements Serializable {
    private static final long serialVersionUID = 3653844494903732108L;
    private String desp;
    private Integer ldbz = 0;
    private Integer ldzz = 0;
}
