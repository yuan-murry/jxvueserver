package com.gxzh.jxvueserver.controller;

import com.github.pagehelper.PageInfo;
import com.gxzh.jxvueserver.dto.*;
import com.gxzh.jxvueserver.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/home")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @RequestMapping("/sydwpie")
    public Res<?> selectSydwpie(@RequestParam("depCode") String depCode) {
        SydwPie sydwPie = this.homeService.selectSydwpie(depCode);
        return Res.ok(sydwPie);
    }

    @RequestMapping("/xzjgpie")
    public Res<?> selectXzjgpie(@RequestParam("depCode") String depCode) {
        XzjgPie xzjgPie = this.homeService.selectXzjgpie(depCode);
        return Res.ok(xzjgPie);
    }

    @RequestMapping("/bzqk")
    public Res<?> selectBzqk(@RequestParam("depCode") String depCode) {
        Bzqk bzqk = this.homeService.selectBzqk(depCode);
        return Res.ok(bzqk);
    }

    @RequestMapping("/xzldzs")
    public Res<?> selectxzldzs(@RequestParam("depCode") String depCode) {
        Ldzs ldzs = this.homeService.selectXzLdzs(depCode);
        return Res.ok(ldzs);
    }

    @RequestMapping("/syldzs")
    public Res<?> selectSyldzs(@RequestParam("depCode") String depCode) {
        Ldzs ldzs = this.homeService.selectSyLdzs(depCode);
        return Res.ok(ldzs);
    }

    @RequestMapping("/getGeoSituation")
    public Res<?> getGeoSituation(@RequestParam("depCode") String depCode) {
        GeoSituation geoSituation = this.homeService.getGeoSituation(depCode);
        return Res.ok(geoSituation);
    }


    @RequestMapping("/selectXzjgLdzsChild")
    public Res<?> selectXzjgLdzsChild(@RequestParam("depCode") String depCode,
                                      @RequestParam("ldzstype") String ldzstype,
                                      @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "10") int pageSize) {
        PageInfo<XzjgLdzsChild> xzjgLdzsChildList = this.homeService.selectXzjgLdzsChild(depCode,ldzstype,pageNum,pageSize);
        return Res.ok(xzjgLdzsChildList);
    }


    @RequestMapping("/selectSyjgLdzsChild")
    public Res<?> selectSyjgLdzsChild(@RequestParam("depCode") String depCode,
                                      @RequestParam("ldzstype") String ldzstype,
                                      @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "10") int pageSize)
     {
        PageInfo<SyjgLdzsChild> syjgLdzsChildList = this.homeService.selectSyjgLdzsChild(depCode,ldzstype,pageNum,pageSize);
        return Res.ok(syjgLdzsChildList);
    }

    @RequestMapping("/selectXzjgPieChild")
    public Res<?> selectXzjgPieChild(@RequestParam("depCode") String depCode,
                                     @RequestParam("depName") String depName,
                                     @RequestParam(value = "1",defaultValue = "1")int pageNum,
                                     @RequestParam(value = "1",defaultValue = "10")int pageSize
    ) {
        PageInfo<XzjgPieChild> xzjgPieChildList = this.homeService.selectXzjgPieChild(depCode,depName,pageNum,pageSize);
        return Res.ok(xzjgPieChildList);
    }

    @RequestMapping("/selectSydwPieChild")
    public Res<?> selectSydwPieChild(@RequestParam("depCode") String depCode,
                                     @RequestParam("depName") String depName,
                                     @RequestParam(value = "1",defaultValue = "1")int pageNum,
                                     @RequestParam(value = "1",defaultValue = "10")int pageSize
                                     ) {
        PageInfo<SydwPieChild> sydwPieChildList = this.homeService.selectSydwPieChild(depCode,depName,pageNum,pageSize);
        return Res.ok(sydwPieChildList);
    }


    @RequestMapping("/selectXzjgLdzsChildDetail")
    public Res<?> selectXzjgLdzsChildDetail(@RequestParam("depCode") String depCode,
                                            @RequestParam("doquery") String doquery,
                                            @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                            @RequestParam(value = "pageSize",defaultValue = "10") int pageSize) {
        PageInfo<XzjgLdzsChildDetail> xzjgLdzsChildDetailList = this.homeService.selectXzjgLdzsChildDetail(depCode,doquery,pageNum,pageSize);
        return Res.ok(xzjgLdzsChildDetailList);
    }

    @RequestMapping("/selectSydwLdzsChildDetail")
    public Res<?> selectSydwLdzsChildDetail(@RequestParam("depCode") String depCode,
                                            @RequestParam("doquery") String doquery,
                                            @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                            @RequestParam(value = "pageSize",defaultValue = "10") int pageSize) {
        PageInfo<SydwLdzsChildDetail> sydwLdzsChildDetailList = this.homeService.selectSydwLdzsChildDetail(depCode,doquery,pageNum,pageSize);
        return Res.ok(sydwLdzsChildDetailList);
    }


    @RequestMapping("/bzqk_fc")
    public Res<?> selectBzqk(@RequestParam("depCode") String depCode,
                             @RequestParam("type") String type,
                             @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){


        PageInfo<Bzqk_fc>   bzqk_fc=  this.homeService.selectBzqk_fc(depCode,type,pageNum,pageSize);


        return Res.ok(bzqk_fc);
    }

    @RequestMapping("/bzqk_fc_sy")
    public Res<?> selectBzqk_sy(@RequestParam("depCode") String depCode,
                                @RequestParam("type") String type,
                                @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "10")int pageSize
                                ) {


        PageInfo<Bzqk_fc_sy>   bzqk_fc_sy=  this.homeService.selectBzqk_sy(depCode,type,pageNum,pageSize);


        return Res.ok(bzqk_fc_sy);
    }



    @RequestMapping("/getXzjgBzsChildDfp")
    public Res<?> getXzjgBzsChildDfp(@RequestParam("depCode") String depCode,
                                     @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                     @RequestParam(value = "pageSize",defaultValue = "10")int pageSize
                                     ) {


        PageInfo<XzjgBzsChildDfp>   xzjgBzsChildDfpList=  this.homeService.getXzjgBzsChildDfp(depCode,pageNum,pageSize);


        return Res.ok(xzjgBzsChildDfpList);
    }

    @RequestMapping("/getSydwBzsChildDfp")
    public Res<?> getSydwBzsChildDfp(@RequestParam("depCode") String depCode,
                                     @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                     @RequestParam(value = "pageSize",defaultValue = "10")int pageSize
                                     ) {


        PageInfo<SydwBzsChildDfp>   sydwBzsChildDfpList=  this.homeService.getSydwBzsChildDfp(depCode,pageNum,pageSize);


        return Res.ok(sydwBzsChildDfpList);
    }


    @RequestMapping("/selectDzq_fc")
    public Res<?> selectDzq_fc(@RequestParam("depCode") String depCode,
                               @RequestParam("type") String type,
                               @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                               @RequestParam(value="pageSize",defaultValue = "10")int pageSize
                               ) {


        PageInfo<Dzq_fc>   dzqfcList=  this.homeService.selectDzq_fc(depCode,type,pageNum,pageSize);


        return Res.ok(dzqfcList);
    }


    @RequestMapping("/selectZf_fc")
    public Res<?> selectZf_fc(@RequestParam("depCode") String depCode,
                              @RequestParam("type") String type,
                              @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize",defaultValue = "10") int pageSize
                              ) {


        PageInfo<Zf_fc>   zffcList=  this.homeService.selectZf_fc(depCode,type,pageNum,pageSize);


        return Res.ok(zffcList);
    }

    @RequestMapping("/getDzqChildDfp")
    public Res<?> getDzqChildDfp(@RequestParam("depCode") String depCode,
                                 @RequestParam(value="pageNum",defaultValue = "1") int pageNum,
                                 @RequestParam(value="pageSize",defaultValue = "10") int pageSize
                                 ) {


        PageInfo<DzqChildDfp>   dzqChildDfpList=  this.homeService.getDzqChildDfp(depCode,pageNum,pageSize);


        return Res.ok(dzqChildDfpList);
    }

    @RequestMapping("/getZfChildDfp")
    public Res<?> getZfChildDfp(@RequestParam("depCode") String depCode,
                                @RequestParam(value="pageNum",defaultValue = "1") int pageNum,
                                @RequestParam(value="pageSize",defaultValue = "10") int pageSize) {


        PageInfo<ZfChildDfp>   zfChildDfpList=  this.homeService.getZfChildDfp(depCode,pageNum,pageSize);


        return Res.ok(zfChildDfpList);
    }
}
