package com.cssl.icewkment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.icewkment.commin.vo.ArticlePageVO;
import com.cssl.icewkment.entity.Article;

public interface ArticleService extends IService<Article> {
    ArticlePageVO VoList(Integer page, Integer limit, Integer click);

    ArticlePageVO FindVoList(Integer page, Integer limit, String content);
}
