package com.gxzh.jxvueserver.controller;

import com.gxzh.jxvueserver.dto.Res;
import com.gxzh.jxvueserver.entity.Ldzs;
import com.gxzh.jxvueserver.entity.Rkbz;
import com.gxzh.jxvueserver.entity.Sybzpzbd;
import com.gxzh.jxvueserver.entity.Xzbzpzbd;
import com.gxzh.jxvueserver.service.CompareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/compare")
public class CompareController {

    @Autowired
    private CompareService compareService;


    @RequestMapping("/selectLdzs")
    public Res<?> selectLdzs(String depcode){
        List<Ldzs> despList=null;

        if(depcode!=null) {
            despList  = compareService.selectLdzs
                    (depcode);

        }


        return Res.ok(despList);
    }



    @RequestMapping("/selectXzbzpzbd")
    public Res<?> selectXzbzpzbd(String depcode){
        List<Xzbzpzbd> despList=null;

        if(depcode!=null) {
            despList  = compareService.selectXzbzpzbd
                    (depcode);

        }


        return Res.ok(despList);
    }

    @RequestMapping("/selectSybzpzbd")
    public Res<?> selectSybzpzbd(String depcode){
        List<Sybzpzbd> despList=null;

        if(depcode!=null) {
            despList  = compareService.selectSybzpzbd
                    (depcode);

        }


        return Res.ok(despList);
    }

    @RequestMapping("/selectRkBzZb")
    public Res<?> selectRkBzZb(String depcode){
        List<Rkbz> despList=null;

        if(depcode!=null) {
            despList  = compareService.selectRkBzZb
                    (depcode);

        }
        return Res.ok(despList);
    }

}
