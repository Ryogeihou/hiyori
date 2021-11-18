package com.ryo.hiyori.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ryo.common.utils.PageUtils;
import com.ryo.hiyori.product.entity.SkuEntity;

import java.util.Map;

/**
 * 
 *
 * @author ryo
 * @email ryogeihou@gmail.com
 * @date 2021-11-09 14:46:27
 */
public interface SkuService extends IService<SkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

