package com.gxzh.jxvueserver.controller;

import com.github.pagehelper.PageInfo;
import com.gxzh.jxvueserver.dto.*;
import com.gxzh.jxvueserver.service.ZzbzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/zzbz")
public class ZzbzController {
    @Autowired
    private ZzbzService zzbzService;

    @RequestMapping("/usecondition")
    public Res<?> getUseCondition(@RequestParam("depCode") String depCode) {
        ZzbzUseCondition useCondition = this.zzbzService.getUseCondition(depCode);
        return Res.ok(useCondition);
    }

    @RequestMapping("/zzbzallot")
    public Res<?> getZzbzAllot(@RequestParam("depCode") String depCode) {
        List<ZzbzAllot> zzbzAllotList = this.zzbzService.getZzbzAllot(depCode);
        return Res.ok(zzbzAllotList);
    }

    @RequestMapping("/staffduty")
    public Res<?> getStaffDuty(@RequestParam("depCode") String depCode) {
        ZzbzStaffDuty staffDuty = this.zzbzService.getStaffDuty(depCode);
        return Res.ok(staffDuty);
    }

    @RequestMapping("/generaluse")
    public Res<?> getGeneralUse(@RequestParam("depCode") String depCode) {
        ZzbzGeneralUse generalUse = this.zzbzService.getGeneralUse(depCode);
        return Res.ok(generalUse);
    }

    @RequestMapping("/recycle")
    public Res<?> getRecycle(@RequestParam("depCode") String depCode) {
        List<ZzbzRecycle> recycle = this.zzbzService.getRecycle(depCode);
        return Res.ok(recycle);
    }

    @RequestMapping("/retire")
    public Res<?> getRetire(@RequestParam("depCode") String depCode) {
        List<ZzbzRetire> retire = this.zzbzService.getRetire(depCode);
        return Res.ok(retire);
    }
    @RequestMapping("/selectZzbzDetail")
    public Res<?> selectZzbzDetail(@RequestParam("depCode") String depCode,
                                   @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "10")int pageSize
                                   ) {

        PageInfo<ZzbzDetail> zzbzDetailList = this.zzbzService.selectZzbzDetail(depCode,pageNum,pageSize);
        return Res.ok(zzbzDetailList);
    }

}
