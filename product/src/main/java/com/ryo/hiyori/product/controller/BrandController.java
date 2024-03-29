package com.ryo.hiyori.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ryo.hiyori.product.entity.BrandEntity;
import com.ryo.hiyori.product.service.BrandService;
import com.ryo.common.utils.PageUtils;
import com.ryo.common.utils.R;



/**
 * 
 *
 * @author ryo
 * @email ryogeihou@gmail.com
 * @date 2021-11-11 20:23:58
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandid}")
    public R info(@PathVariable("brandid") Integer brandid){
		BrandEntity brand = brandService.getById(brandid);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BrandEntity brand){
		brandService.save(brand);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BrandEntity brand){
		brandService.updateById(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer brandid){
		brandService.removeByIds(Arrays.asList(brandid));

        return R.ok();
    }

}
