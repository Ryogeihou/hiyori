package com.ryo.hiyori.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ryo.hiyori.product.entity.CateEntity;
import com.ryo.hiyori.product.service.CateService;
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
@RequestMapping("product/category")
public class CateController {
    @Autowired
    private CateService cateService;


    @RequestMapping("/list/tree")
    public R listWithTree () {
        List<CateEntity> list = cateService.listWithTree();

        return R.ok().put("data", list);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        params.put("limit","2");
        PageUtils page = cateService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
		CateEntity cate = cateService.getById(id);

        return R.ok().put("cate", cate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CateEntity cate){
		cateService.save(cate);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CateEntity cate){
		cateService.updateById(cate);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] catIds){
//		cateService.removeByIds(Arrays.asList(ids));

        cateService.removeMenuByIds(Arrays.asList(catIds));
        return R.ok();
    }

}
