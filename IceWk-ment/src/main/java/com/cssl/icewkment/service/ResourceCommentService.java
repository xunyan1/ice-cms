package com.cssl.icewkment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.icewkment.entity.ResourceComment;

public interface ResourceCommentService extends IService<ResourceComment> {
    int GetCommentNum(Integer resourceId);
}
