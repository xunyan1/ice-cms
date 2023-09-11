package com.cssl.icewkment.commin.vo;

import com.cssl.icewkment.entity.ResourceClass;
import lombok.Data;

import java.util.List;

@Data
public class ResourceClassPageVO {
    private List<ResourceClass> data;
    private Long total;
}