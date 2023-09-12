package com.cssl.icewkment.commin.vo;

import com.cssl.icewkment.entity.ArticleClass;
import lombok.Data;

import java.util.List;

@Data
public class ArticleClassPageVO {
    private List<ArticleClass> data;
    private Long total;
}
