package com.ryo.hiyori.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryo.common.utils.PageUtils;
import com.ryo.common.utils.Query;

import com.ryo.hiyori.product.dao.CateDao;
import com.ryo.hiyori.product.entity.CateEntity;
import com.ryo.hiyori.product.service.CateService;


@Service("cateService")
public class CateServiceImpl extends ServiceImpl<CateDao, CateEntity> implements CateService {

//    @Autowired
//    CateDao cateDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CateEntity> page = this.page(
                new Query<CateEntity>().getPage(params),
                new QueryWrapper<CateEntity>()
        );

        return new PageUtils(page);
    }

    public List<CateEntity> listWithTree () {

        List<CateEntity> entities = baseMapper.selectList(null);

        return entities;
    }

}