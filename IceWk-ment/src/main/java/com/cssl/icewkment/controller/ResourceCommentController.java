package com.cssl.icewkment.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cssl.icewkment.entity.ResourceComment;
import com.cssl.icewkment.mapper.ResourceCommentMapper;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@io.swagger.annotations.Api(tags = "后台资源评论管理接口")
@RestController
@RequestMapping("/ResourceComment")
public class ResourceCommentController {

    @Autowired
    private ResourceCommentMapper resourceCommentMapper;

    @ApiOperation(value = "获取全部评论")
    @RequiresAuthentication  //需要登陆认证的接口
    @GetMapping("/getAllResourceComments")
    public List<ResourceComment> getAllResourceComments(
    ) {
        QueryWrapper<ResourceComment> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("add_time");
        return resourceCommentMapper.selectList(wrapper);
    }
}

