package com.cssl.icewkment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.icewkment.commin.vo.ResourcePageVO;
import com.cssl.icewkment.commin.vo.ResourceVO;
import com.cssl.icewkment.entity.Resource;

import java.util.List;

public interface ResourceService extends IService<Resource> {
    ResourcePageVO VoList(Integer page, Integer limit);

    ResourcePageVO VoListFilter(Integer page, Integer limit, Integer rclass, String filter);

    List<ResourceVO> ClassVoList(Integer id);

    List<ResourceVO> GetNewResource(Integer num,String filter);

    ResourcePageVO FindVoList(Integer page, Integer limit, String content);
}
