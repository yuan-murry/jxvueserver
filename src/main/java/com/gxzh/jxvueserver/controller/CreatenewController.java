package com.gxzh.jxvueserver.controller;

import com.gxzh.jxvueserver.dto.Res;
import com.gxzh.jxvueserver.entity.Createnew;
import com.gxzh.jxvueserver.service.CreatenewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/createnew")
public class CreatenewController {
    @Autowired
    private CreatenewService createnewService;

    @RequestMapping("/selectCreatenew")
    public Res<?> selectCreatenew(String depcode) {
        List<Createnew> despList = null;

        if (depcode != null) {
            despList = createnewService.selectCreatenew
                    (depcode);

        }


        return Res.ok(despList);
    }


}
