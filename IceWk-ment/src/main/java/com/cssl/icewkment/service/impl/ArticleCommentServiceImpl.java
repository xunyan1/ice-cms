package com.cssl.icewkment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.icewkment.entity.ArticleComment;
import com.cssl.icewkment.mapper.ArticleCommentMapper;
import com.cssl.icewkment.mapper.ArticleMapper;
import com.cssl.icewkment.service.ArticleCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleCommentServiceImpl  extends ServiceImpl<ArticleCommentMapper, ArticleComment> implements ArticleCommentService {

    @Autowired
    private ArticleCommentMapper articleCommentMapper;
    @Override
    public int GetCommentNum(Integer articleId) {
        QueryWrapper<ArticleComment> wrapper = new QueryWrapper<>();
        wrapper.eq("article_id",articleId);
        return articleCommentMapper.selectCount(wrapper);
    }
}
