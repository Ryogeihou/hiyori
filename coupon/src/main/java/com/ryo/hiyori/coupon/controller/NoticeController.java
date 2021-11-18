package com.ryo.hiyori.coupon.controller;

import java.util.Arrays;
import java.util.Map;

import com.ryo.hiyori.coupon.feign.MemberFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ryo.hiyori.coupon.entity.NoticeEntity;
import com.ryo.hiyori.coupon.service.NoticeService;
import com.ryo.common.utils.PageUtils;
import com.ryo.common.utils.R;



/**
 * 
 *
 * @author ryo
 * @email ryogeihou@gmail.com
 * @date 2021-11-15 18:09:18
 */
@RefreshScope
@RestController
@RequestMapping("coupon/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @Autowired
    MemberFeignService memberFeignService;

    @Value("${coupon.user.name}")
    private String name;
    @Value("${coupon.user.age}")
    private Integer age;

    @RequestMapping("/test")
    public R test () {
        return R.ok().put("name", name).put("age", age);
    }

    @RequestMapping("/memberList")
    public R getMemberList () {
        R memberList = memberFeignService.list();

//        return R.ok().put("memberlist", memberList.get("list"));  return null find reason //TODO
        return R.ok().put("memberlist", Arrays.asList(memberList));
    }

    @RequestMapping("/member/notice")
    public R memberNotice () {
        NoticeEntity noticeEntity = new NoticeEntity();
        noticeEntity.setTitle("test:for members'notice");
        noticeEntity.setType(3);

        return R.ok().put("notice", Arrays.asList(noticeEntity));
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = noticeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		NoticeEntity notice = noticeService.getById(id);

        return R.ok().put("notice", notice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NoticeEntity notice){
		noticeService.save(notice);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody NoticeEntity notice){
		noticeService.updateById(notice);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		noticeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
