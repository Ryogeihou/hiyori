package com.hiyori.product;

import com.ryo.hiyori.product.entity.SkuEntity;
import com.ryo.hiyori.product.service.SkuService;
import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
class ProductApplicationTests {

    @Autowired
//    SkuService skuService;
    SkuEntity skuEntity;

    @Test
    void contextLoads() {
        SkuEntity skuEntity = new SkuEntity();
        skuEntity.setTitle("test");
        skuEntity.setRhid(666);
        System.out.println("ok");
    }

}
