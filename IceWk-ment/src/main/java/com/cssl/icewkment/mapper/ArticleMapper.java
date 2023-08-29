package com.cssl.icewkment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cssl.icewkment.entity.Article;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleMapper extends BaseMapper<Article> {

}
