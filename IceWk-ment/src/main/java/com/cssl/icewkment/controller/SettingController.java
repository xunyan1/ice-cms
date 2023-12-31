package com.cssl.icewkment.controller;


import com.cssl.icewkment.entity.DispositionCarousel;
import com.cssl.icewkment.entity.Setting;
import com.cssl.icewkment.mapper.DispositionCarouselMapper;
import com.cssl.icewkment.mapper.SettingMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@io.swagger.annotations.Api(tags = "后台设置接口")
@RestController
@RequestMapping("/Sitting")
public class SettingController {

    @Autowired
    private SettingMapper settingMapper;

    @Autowired
    private DispositionCarouselMapper dispositionCarouselMapper;

    @ApiOperation(value = "修改设置")
    @ApiImplicitParam(name = "setting",value = "设置",required = true)
    @PostMapping("/setSetting")
    public int setSetting(
            @RequestBody Setting setting
    ) {
        return settingMapper.updateById(setting);
    }

    @ApiOperation(value = "获取oss配置")
    @GetMapping("/getCosSetting")
    public Setting getCosSetting(
    ) {
        return settingMapper.selectOne(null);
    }

    @ApiOperation(value = "修改设置")
    @ApiImplicitParam(name = "setting",value = "设置",required = true)
    @PostMapping("/setSettingCos")
    public int setSettingCos(
            @RequestBody Setting setting
    ) {
        return settingMapper.update(setting,null);
    }

    @ApiOperation(value = "获取全部轮播图")
    @ApiImplicitParam(name = "setting",value = "设置",required = true)
    @GetMapping("/getAllDispositionCarousel")
    public List<DispositionCarousel> getAllDispositionCarousel(
    ) {
        return dispositionCarouselMapper.selectList(null);
    }

}

