package com.ryo.hiyori.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ryo.hiyori.product.entity.SkuEntity;
import com.ryo.hiyori.product.service.SkuService;
import com.ryo.common.utils.PageUtils;
import com.ryo.common.utils.R;



/**
 * 
 *
 * @author ryo
 * @email ryogeihou@gmail.com
 * @date 2021-11-09 14:46:27
 */
@RestController
@RequestMapping("product/sku")
public class SkuController {
    @Autowired
    private SkuService skuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = skuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/infoByRhid/{rhid}")
    public R info(@PathVariable("rhid") Integer rhid){
//		List<SkuEntity> list = skuService.list(new QueryWrapper<SkuEntity>().eq("rhid",rhid));
//        list.forEach(item -> {
//            System.out.println(item);
//        });
        SkuEntity skuEntity= skuService.getOne(new QueryWrapper<SkuEntity>().eq("rhid",rhid), true);

        return R.ok().put("sku", skuEntity);
    }


    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SkuEntity sku){
		skuService.save(sku);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SkuEntity sku){
		skuService.updateById(sku);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		skuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
