package com.gxzh.jxvueserver.controller;

import com.gxzh.jxvueserver.dto.Res;
import com.gxzh.jxvueserver.entity.Cbz;
import com.gxzh.jxvueserver.service.WtyjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/wtyj")
public class WtyjController {
    @Autowired
    private WtyjService wtyjService;


    @RequestMapping("/selectCbz")
    public Res<?> selectCbz(String depcode){
        List<Cbz> despList=null;

        if(depcode!=null) {
            despList  = wtyjService.selectCbz
                    (depcode);

        }


        return Res.ok(despList);
    }







}
