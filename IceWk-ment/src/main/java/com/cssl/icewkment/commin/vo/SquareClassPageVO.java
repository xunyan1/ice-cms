package com.cssl.icewkment.commin.vo;

import com.cssl.icewkment.entity.SquareClass;
import lombok.Data;

import java.util.List;

@Data
public class SquareClassPageVO {
    private List<SquareClass> data;
    private Long total;
}