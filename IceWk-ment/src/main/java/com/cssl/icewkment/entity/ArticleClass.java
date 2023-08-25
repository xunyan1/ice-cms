package com.cssl.icewkment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class ArticleClass implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 父级分类
     */
    private Integer father;

    /**
     * 别名
     */
    private String otherName;

    /**
     * 描述
     */
    private String describes;

    /**
     * 分类图片
     */
    private String imgclass;

    /**
     * 顶制
     */
    private Integer top;

    /**
     * 文章数量
     */
    private Integer num;

}
