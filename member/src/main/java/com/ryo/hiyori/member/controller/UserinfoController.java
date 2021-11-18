package com.ryo.hiyori.member.controller;

import java.util.Arrays;
import java.util.Map;

import com.ryo.hiyori.member.feign.CouponFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ryo.hiyori.member.entity.UserinfoEntity;
import com.ryo.hiyori.member.service.UserinfoService;
import com.ryo.common.utils.PageUtils;
import com.ryo.common.utils.R;



/**
 * 
 *
 * @author ryo
 * @email ryogeihou@gmail.com
 * @date 2021-11-15 18:29:26
 */
@RestController
@RequestMapping("member/userinfo")
public class UserinfoController {
    @Autowired
    private UserinfoService userinfoService;

    @Autowired
    CouponFeignService couponFeignService;

    @RequestMapping("/notice")
    public R memberNoticeTest () {
        UserinfoEntity userinfoEntity = new UserinfoEntity();
        userinfoEntity.setNickname("test");
        userinfoEntity.setGender(0);

        R memberNotice = couponFeignService.memberNotice();

        return R.ok().put("memberInfo", userinfoEntity).put("notice", memberNotice.get("notice"));
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userinfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		UserinfoEntity userinfo = userinfoService.getById(id);

        return R.ok().put("userinfo", userinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody UserinfoEntity userinfo){
		userinfoService.save(userinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody UserinfoEntity userinfo){
		userinfoService.updateById(userinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		userinfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
