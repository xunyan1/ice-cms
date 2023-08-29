package com.cssl.icewkment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.icewkment.commin.vo.ResourceClassPageVO;
import com.cssl.icewkment.entity.ResourceClass;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceClassService extends IService<ResourceClass> {
    ResourceClassPageVO GetList(Integer page, Integer limit);
}
