package com.ryo.hiyori.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ryo.common.utils.PageUtils;
import com.ryo.hiyori.product.entity.CateEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ryo
 * @email ryogeihou@gmail.com
 * @date 2021-11-11 20:23:58
 */
public interface CateService extends IService<CateEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CateEntity> listWithTree();
//    List<CateEntity> listWithTrees();

    void removeMenuByIds(List<Long> asList);
}

