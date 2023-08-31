package com.cssl.icewkment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.icewkment.entity.ResourceComment;
import com.cssl.icewkment.mapper.ResourceCommentMapper;
import com.cssl.icewkment.service.ResourceCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceCommentServiceImpl extends ServiceImpl<ResourceCommentMapper, ResourceComment> implements ResourceCommentService {
    @Autowired
    private ResourceCommentMapper resourceCommentMapper;

    @Override
    public int GetCommentNum(Integer resourceId) {
        QueryWrapper<ResourceComment> wrapper = new QueryWrapper<>();
        wrapper.eq("resource_id",resourceId);
        return resourceCommentMapper.selectCount(wrapper);
    }
}
