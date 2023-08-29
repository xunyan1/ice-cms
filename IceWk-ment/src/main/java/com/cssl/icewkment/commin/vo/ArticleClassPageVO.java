package com.cssl.icewkment.commin.vo;

import com.cssl.icewkment.entity.ArticleClass;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ArticleClassPageVO implements Serializable {
    private List<ArticleClass> data;
    private Long total;
}
