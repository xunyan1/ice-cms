package com.cssl.icewkment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.icewkment.entity.SquareComment;

import java.util.List;

public interface SquareCommentService extends IService<SquareComment> {
    Integer GetCommentNum(Integer planetId);
    List<SquareComment> VoList(Integer page, Integer limit);
}
