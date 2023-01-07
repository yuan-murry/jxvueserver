package com.gxzh.jxvueserver.dto;

import lombok.Data;

@Data
public class Res<T> {
    private Integer code;
    private String msg;
    private Object data;

    public Res() {}

    public Res(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Res<?> ok(){
        return new Res<>(1,"success",null);
    }
    public static Res<?> ok(String msg){
        return new Res<>(1,msg,null);
    }
    public static Res<?> ok(Object data){
        return new Res<>(1,"success",data);
    }
    public static Res<?> ok(String msg,Object data){
        return new Res<>(1,msg,data);
    }

    public static Res<?> fail(String msg){
        return new Res<>(-1,msg,null);
    }
    public static Res<?> fail(Integer code,String msg){
        return new Res<>(code,msg,null);
    }
}
