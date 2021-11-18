package com.ryo.hiyori.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryo.common.utils.PageUtils;
import com.ryo.common.utils.Query;

import com.ryo.hiyori.member.dao.UserinfoDao;
import com.ryo.hiyori.member.entity.UserinfoEntity;
import com.ryo.hiyori.member.service.UserinfoService;


@Service("userinfoService")
public class UserinfoServiceImpl extends ServiceImpl<UserinfoDao, UserinfoEntity> implements UserinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserinfoEntity> page = this.page(
                new Query<UserinfoEntity>().getPage(params),
                new QueryWrapper<UserinfoEntity>()
        );

        return new PageUtils(page);
    }

}