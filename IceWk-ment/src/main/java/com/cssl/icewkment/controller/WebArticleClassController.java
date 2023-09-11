package com.cssl.icewkment.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cssl.icewkment.entity.Article;
import com.cssl.icewkment.entity.ArticleClass;
import com.cssl.icewkment.mapper.ArticleClassMapper;
import com.cssl.icewkment.mapper.ArticleMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@io.swagger.annotations.Api(tags = "Web文章分类接口")
@RestController
@RequestMapping("/WebarticleClass")
public class WebArticleClassController {
    @Autowired
    private ArticleMapper articleMapper;

    private ArticleClassMapper articleClassMapper;

    @ApiOperation(value = "根据分类id获取文章数量")
    @ApiImplicitParam(name = "id", value = "id", required = true)
    @GetMapping("/getArticleClassNum/{id}")
    public int getArticleClassNum(
            @PathVariable("id") Integer id
    ) {
        QueryWrapper<Article> wrapper = new QueryWrapper<Article>();
        wrapper.eq("sort_class", id);
        return articleMapper.selectCount(wrapper);
    }

    @ApiOperation(value = "获取全部分类列表")
    @GetMapping("/getArticleClasslist")
    public List<ArticleClass> getArticleClasslist(
    ) {
        return articleClassMapper.selectList(null);
    }
}
