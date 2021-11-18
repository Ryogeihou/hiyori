package com.ryo.hiyori.member.feign;

import com.ryo.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/notice/member/notice")
    public R memberNotice ();
}
