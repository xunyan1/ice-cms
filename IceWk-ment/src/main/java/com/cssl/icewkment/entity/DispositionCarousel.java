package com.cssl.icewkment.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Data
@EqualsAndHashCode(callSuper = false)
public class DispositionCarousel implements Serializable {

    private Integer id;
    private String title;
    private String introduce;
    private String button;
    private String img;

}
