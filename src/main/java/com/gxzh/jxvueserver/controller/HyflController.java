package com.gxzh.jxvueserver.controller;

import com.gxzh.jxvueserver.dto.BzzyIndstry;
import com.gxzh.jxvueserver.dto.Res;
import com.gxzh.jxvueserver.service.HyflService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hyfl")
public class HyflController {

    @Autowired
    private HyflService hyflService;


    @RequestMapping("/industry")
    public Res<?> getInsdstry(@RequestParam("depCode") String depCode) {
        List<BzzyIndstry> insdstry = this.hyflService.getInsdstry(depCode);
        return Res.ok(insdstry);
    }


    @RequestMapping("/industryChild")
    public Res<?> getInsdstryChild(@RequestParam("depCode") String depCode, @RequestParam("flCode") String flCode) {
        List<BzzyIndstry> insdstry = this.hyflService.getInsdstryChild(depCode, flCode);
        return Res.ok(insdstry);
    }
}
