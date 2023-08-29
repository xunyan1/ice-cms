package com.cssl.icewkment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.icewkment.entity.ArticleComment;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleCommentService extends IService<ArticleComment> {
    int GetCommentNum(Integer articleId);
}
