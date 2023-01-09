package com.gxzh.jxvueserver.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class BzzyIndstry implements Serializable {
    private static final long serialVersionUID = 3291698193190304844L;
    private String hyname;
    private Integer bzs = 0;
    private Integer zzs = 0;
}
