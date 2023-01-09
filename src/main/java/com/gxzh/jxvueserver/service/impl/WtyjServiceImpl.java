package com.gxzh.jxvueserver.service.impl;

import com.gxzh.jxvueserver.entity.Cbz;
import com.gxzh.jxvueserver.mapper.WtyjMapper;
import com.gxzh.jxvueserver.service.WtyjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WtyjServiceImpl implements WtyjService {
@Autowired
private WtyjMapper wtyjMapper;

    public List<Cbz> selectCbz(String depcode){
        String code ="360000";
        List<Cbz> despList=null;
        if(depcode!=null && depcode.indexOf("__")!=-1){

        }else{
            code=depcode.replace("%","00");
        }
        despList= wtyjMapper.selectCbz(depcode,code);

        return despList;
    }
}
