package com.ryo.hiyori.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ryo.common.utils.PageUtils;
import com.ryo.hiyori.coupon.entity.NoticeEntity;

import java.util.Map;

/**
 * 
 *
 * @author ryo
 * @email ryogeihou@gmail.com
 * @date 2021-11-15 18:09:18
 */
public interface NoticeService extends IService<NoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

