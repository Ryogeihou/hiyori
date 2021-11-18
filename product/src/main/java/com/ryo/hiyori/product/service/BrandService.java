package com.ryo.hiyori.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ryo.common.utils.PageUtils;
import com.ryo.hiyori.product.entity.BrandEntity;

import java.util.Map;

/**
 * 
 *
 * @author ryo
 * @email ryogeihou@gmail.com
 * @date 2021-11-11 20:23:58
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

