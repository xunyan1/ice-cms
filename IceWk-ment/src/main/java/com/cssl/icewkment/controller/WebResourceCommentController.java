package com.cssl.icewkment.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cssl.icewkment.entity.ResourceComment;
import com.cssl.icewkment.mapper.ResourceCommentMapper;
import com.cssl.icewkment.mapper.ResourceMapper;
import com.cssl.icewkment.service.ResourceCommentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@io.swagger.annotations.Api(tags = "Web资源评论接口")
@RestController
@RequestMapping("/WebResourceComment")
public class WebResourceCommentController {


    @Autowired
    private ResourceCommentMapper resourceCommentMapper;

    @Autowired
    private ResourceCommentService resourceCommentService;

    @Autowired
    private ResourceMapper resourceMapper;

    @ApiOperation(value = "根据资源id查询对应的评论")
    @ApiImplicitParam(name = "resourceId",value = "资源id",required = true)
    @GetMapping("/getallResourceComment/{resourceId}")
    public List<ResourceComment> getallResourceComment(
            @PathVariable("resourceId") Integer resourceId
    ) {

        QueryWrapper<ResourceComment> wrapper = new QueryWrapper<>();
        wrapper.eq("resource_id",resourceId);

        return resourceCommentMapper.selectList(wrapper);
    }

    @ApiOperation(value = "增加评论")
    @PostMapping("/addResourceComment")
    @ApiImplicitParam(name = "resourceComment",value = "资源分类对象",required = true)
    public int addResourceComment(@RequestBody ResourceComment resourceComment) {
        return resourceCommentMapper.insert(resourceComment);
    }

    @ApiOperation(value = "查看文章对应评论数")
    @ApiImplicitParam(name = "resourceId",value = "资源id",required = true)
    @GetMapping("/getResourceCommentnum/{resourceId}")
    public int getResourceCommentnum(
            @PathVariable("resourceId") Integer resourceId
    ) {

        return resourceCommentService.GetCommentNum(resourceId);
    }
}

