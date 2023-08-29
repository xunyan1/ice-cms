package com.cssl.icewkment.commin.vo;

import lombok.Data;

import java.util.List;

@Data
public class ArticlePageVO {
    private List<ArticleVO> data;
    private Long total;
    private Long Pages;
}
