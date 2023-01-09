package com.gxzh.jxvueserver.service.impl;


import com.gxzh.jxvueserver.entity.Ldzs;
import com.gxzh.jxvueserver.entity.Sybzpzbd;
import com.gxzh.jxvueserver.entity.Xzbzpzbd;
import com.gxzh.jxvueserver.mapper.CompareMapper;
import com.gxzh.jxvueserver.service.CompareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompareServiceImpl implements CompareService {
    @Autowired
    private CompareMapper compareMapper;


    public List<Ldzs> selectLdzs(String depcode){
        String code ="360000";
        List<Ldzs> despList=null;
        if(depcode!=null && depcode.indexOf("__")!=-1){

        }else{
            code=depcode.replace("%","00");
        }
      despList= compareMapper.selectLdzs(depcode,code);

      return despList;
    }

    public List<Xzbzpzbd> selectXzbzpzbd(String depcode){
        String code ="360000";
        List<Xzbzpzbd> despList=null;
        if(depcode!=null && depcode.indexOf("__")!=-1){

        }else{
            code=depcode.replace("%","00");
        }
        despList= compareMapper.selectXzbzpzbd(depcode,code);

        return despList;
    }

    public List<Sybzpzbd> selectSybzpzbd(String depcode){
        String code ="360000";
        List<Sybzpzbd> despList=null;
        if(depcode!=null && depcode.indexOf("__")!=-1){

        }else{
            code=depcode.replace("%","00");
        }
        despList= compareMapper.selectSybzpzbd(depcode,code);

        return despList;
    }

}
