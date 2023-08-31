package com.cssl.icewkment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.icewkment.commin.vo.SquareClassPageVO;
import com.cssl.icewkment.entity.SquareClass;

public interface SquareClassService extends IService<SquareClass> {
    SquareClassPageVO GetList(Integer page, Integer limit);
}
