package com.chinaYouthHealth.payment.manager.api;

import com.chinaYouthHealth.payment.manager.util.JsonUtils;
import com.gomefinance.promotion.api.PromotionAPIService;
import com.gomefinance.promotion.dto.*;
import com.gomefinance.promotion.manager.PromotionManagerApplication;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Strings;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PromotionManagerApplication.class)
public class PromotionAPIServiceTest {
    private static final Logger log = LoggerFactory.getLogger(TActivityServiceImpl.class);

    @Autowired
    private PromotionAPIService promotionAPIService;

    @Test
    public void findTActivityList() {
        Map<String, String> map = new HashMap<>();
        map.put("merchantType", "1");
        map.put("storeCode", "A726");
        map.put("creditCardType", null);
        List<ActivityApiDto> list = promotionAPIService.findActivityList(map);
        log.info("返回的活动：" + JsonUtils.toJson(list));
    }

    @Test
    public void findTActivityProductList() {
        List<ProductApiDto> set = promotionAPIService.findActivityProductSet("1", "MYF2017005574","A4SG");
        System.out.println(JsonUtils.toJson(set));
    }

    @Test
    public void findTProductDetailList() {
        List<ProductDetailApiDto> tProductDetailList = promotionAPIService.findProductDetailList("MYFEN", "6606");
        System.out.println(JsonUtils.toJson(tProductDetailList));
    }

    @Test
    public void findTGoods() {
        System.out.println("====" + System.currentTimeMillis());
        GoodsApiDto tGoods = promotionAPIService.findGoods("1", "", "100422442", null);
        System.out.println("====" + System.currentTimeMillis());
        System.out.println(JsonUtils.toJson(tGoods));
    }

    @Test
    public void checkGoodsCount() {
        ActivityGoodsApiDto activityGoodsApiDto = new ActivityGoodsApiDto();
        activityGoodsApiDto.setActivityCode("MYF2017005577");
        activityGoodsApiDto.setActivityName("恶心逻辑测试");
        activityGoodsApiDto.setType("1");
        List<GoodsCheckApiDto> goodsCheckApiDtos = Lists.newArrayList();
        GoodsCheckApiDto goodsCheckApiDto = new GoodsCheckApiDto();
        goodsCheckApiDto.setGoodsCode("100253556");
        goodsCheckApiDto.setGoodsName("爱车怕的");
        goodsCheckApiDto.setCount(3);
        goodsCheckApiDto.setCategoryCode("R18");
        goodsCheckApiDto.setBrandCode("01344");
        goodsCheckApiDto.setIsThreeCorridors("N");
        goodsCheckApiDtos.add(goodsCheckApiDto);
        GoodsCheckApiDto goodsCheckApiDto1 = new GoodsCheckApiDto();
        goodsCheckApiDto1.setGoodsCode("100033638");
        goodsCheckApiDto1.setGoodsName("爱车怕的");
        goodsCheckApiDto1.setCount(5);
        goodsCheckApiDto1.setCategoryCode("R06");
        goodsCheckApiDto1.setBrandCode("00033");
        goodsCheckApiDto1.setIsThreeCorridors("N");
        goodsCheckApiDtos.add(goodsCheckApiDto1);

        activityGoodsApiDto.setGoodsCheckApiDtoList(goodsCheckApiDtos);
        GoodsCheckApiDto tGoods = promotionAPIService.checkGoodsCount(activityGoodsApiDto);
        System.out.println(JsonUtils.toJson(tGoods));
    }

    @Test
    public void checkGoodsJoinActivity() {
        String activityCode = "MYF2017005598";
        List<GoodsActivityCheckApiDto> goodsCheckApiDtoList = Lists.newArrayList();
        GoodsActivityCheckApiDto g1 = new GoodsActivityCheckApiDto();
        g1.setCategoryCode("R12");
        g1.setBrandCode("04750");
        g1.setGoodsCode("100000027");
        g1.setIsThreeCorridors("Y");
        goodsCheckApiDtoList.add(g1);
        Map<String, Object> tGoods = promotionAPIService.checkGoodsJoinActivity(activityCode,goodsCheckApiDtoList);
        System.out.println("返回数据" + JsonUtils.toJson(tGoods));
    }

    @Test
    public void findGoodsActivityCount() {
        ActivityGoodsApiDto activityGoodsApiDto = new ActivityGoodsApiDto();
        activityGoodsApiDto.setActivityCode("MYF2017005577");
        activityGoodsApiDto.setActivityName("恶心逻辑测试");
        activityGoodsApiDto.setType("1");
        List<GoodsCheckApiDto> goodsCheckApiDtos = Lists.newArrayList();
        GoodsCheckApiDto goodsCheckApiDto = new GoodsCheckApiDto();
        goodsCheckApiDto.setGoodsCode("100253556");
        goodsCheckApiDto.setGoodsName("爱车怕的");
        goodsCheckApiDto.setCount(3);
        goodsCheckApiDto.setCategoryCode("R18");
        goodsCheckApiDto.setBrandCode("01344");
        goodsCheckApiDto.setIsThreeCorridors("N");
        goodsCheckApiDtos.add(goodsCheckApiDto);
        GoodsCheckApiDto goodsCheckApiDto1 = new GoodsCheckApiDto();
        goodsCheckApiDto1.setGoodsCode("100033638");
        goodsCheckApiDto1.setGoodsName("爱车怕的");
        goodsCheckApiDto1.setCount(5);
        goodsCheckApiDto1.setCategoryCode("R06");
        goodsCheckApiDto1.setBrandCode("00033");
        goodsCheckApiDto1.setIsThreeCorridors("N");
        goodsCheckApiDtos.add(goodsCheckApiDto1);

        activityGoodsApiDto.setGoodsCheckApiDtoList(goodsCheckApiDtos);
        List<GoodsCheckApiDto> tGoods = promotionAPIService.findGoodsActivityCount(activityGoodsApiDto);
        System.out.println(JsonUtils.toJson(tGoods));
    }
}

