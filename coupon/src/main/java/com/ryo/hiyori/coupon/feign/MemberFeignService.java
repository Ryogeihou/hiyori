package com.ryo.hiyori.coupon.feign;

import com.ryo.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("member")
public interface memberList {
    @RequestMapping("/member/userinfo/list")
    public R list(@RequestParam Map<String, Object> params);
}
