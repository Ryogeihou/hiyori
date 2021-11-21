package com.ryo.hiyori.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        List<CateEntity> level1Menus = entities.stream().filter(cateEntity ->
                cateEntity.getParentid() == 0
        ).map((menu)->{
            menu.setChildren(getChildren(menu,entities));
            return menu;
        }).sorted((menu1,menu2)->{
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());

        return level1Menus;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO  1、检查当前删除的菜单，是否被别的地方引用
        baseMapper.deleteBatchIds(asList);
    }

    private List<CateEntity> getChildren(CateEntity root, List<CateEntity> all) {

        List<CateEntity> children = all.stream().filter(cateEntity -> {
            return cateEntity.getParentid() - 0 == root.getCatId() - 0;
        }).map(categoryEntity -> {
            //1、找到子菜单
            categoryEntity.setChildren(getChildren(categoryEntity,all));
            return categoryEntity;
        }).sorted((menu1,menu2)->{
            //2、菜单的排序
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());

        return children;
    }

}