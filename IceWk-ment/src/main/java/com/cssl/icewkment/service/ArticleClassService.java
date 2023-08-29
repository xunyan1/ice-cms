package com.cssl.icewkment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.icewkment.commin.vo.ArticleClassPageVO;
import com.cssl.icewkment.entity.ArticleClass;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleClassService extends IService<ArticleClass> {
    ArticleClassPageVO GetList(Integer page, Integer limit);

}
