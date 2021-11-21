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
        ).map( (menu) ->{
            menu.setChildren(getChildren(menu, entities));
            return menu;
        }).sorted((menu1, menu2) -> {
            return menu2.getSort() -menu1.getSort();
        }).collect(Collectors.toList());

        return level1Menus ;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        baseMapper.deleteBatchIds(asList);
    }

    public List<CateEntity> getChildren (CateEntity root, List<CateEntity> all) {

        List<CateEntity> children = all.stream().filter( cateEntity -> {
//            System.out.println("Pid");
//            System.out.println(cateEntity.getParentid());
//            System.out.println("rootCid");
//            System.out.println(root.getCatId());
//            if( cateEntity.getParentid() - 0 == root.getCatId() - 0){
//                System.out.println(cateEntity.getParentid() - 0 == root.getCatId() - 0);
//            }
            //TODO 减0强制转换类型为数字 源码无-0 待验证
            return cateEntity.getParentid() - 0 == root.getCatId() - 0;
        }).map(cateEntity -> {cateEntity.setChildren(getChildren(cateEntity, all));
                return cateEntity;
        }).sorted((menu1, menu2) -> {
            return menu2.getSort() - menu1.getSort();
        }).collect(Collectors.toList());

        return children;
    }


}