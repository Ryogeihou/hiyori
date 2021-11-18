package com.ryo.hiyori.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ryo.common.utils.PageUtils;
import com.ryo.hiyori.member.entity.UserinfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author ryo
 * @email ryogeihou@gmail.com
 * @date 2021-11-15 18:29:26
 */
public interface UserinfoService extends IService<UserinfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

