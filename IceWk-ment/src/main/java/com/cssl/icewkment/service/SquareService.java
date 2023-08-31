package com.cssl.icewkment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.icewkment.commin.vo.SquarePageVO;
import com.cssl.icewkment.entity.Square;

public interface SquareService extends IService<Square> {
    SquarePageVO VoList(String otherName, Integer page, Integer limit);
}
