package com.chinaYouthHealth.payment.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.chinaYouthHealth.payment.manager.util.ExcelHelper;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.gomefinance.fen.mc.agent.api.IGoodsAPIService;
import com.gomefinance.fen.mc.agent.dto.GoodsBasicDto;
import com.gomefinance.promotion.manager.PromotionManagerApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PromotionManagerApplication.class)
public class TGoodsServiceTest {

    private static final Logger log = LoggerFactory.getLogger(TGoodsServiceTest.class);
    
    @Autowired
    private TGoodsService tGoodsService;
    
    @Autowired
    IGoodsAPIService goodsAPIService;
    
    /**
     * 测试商品查询
     */
    @Test
    public void queryActivityByPage() {
        TGoodsSearchDto tGoodsSearchDto = new TGoodsSearchDto();
        tGoodsSearchDto.setCurpageNum(1);
        tGoodsSearchDto.setCurpageSize(10);
        PageInfo<TGoodsDto> pageInfo = tGoodsService.queryTGoodsOrBySku("MYF2017000001", tGoodsSearchDto);
        log.info("total::::"+pageInfo.getTotal()+"");
    }
    
    /**
     * 导入商品
     */
    @Test
    public void importGoods(){
        //
        try {
            List<String> result = ExcelHelper.exportListFromExcel(new File("d:/SKU 1500.xlsx"),0);
            result = result.stream().filter(s-> StringUtils.isNotBlank(s)).collect(Collectors.toList());
            tGoodsService.batchInsertTGoods(result, 23, "4");
        } catch (IOException e) {
            log.info("导入商品失败");
        }catch(Exception e){
            e.printStackTrace();
            log.info(e.getMessage());
        }
    }
    @Test
    public void delGoods(){
        long id=3;
        tGoodsService.deleteTGoodsById(3);
        tGoodsService.deleteTGoodsById(4);
    }
    @Test
    public void goodDubooServiceTest(){
        /**
         * 编号和类型
         */
        String result = goodsAPIService.findGoodsByCodeAndType("000000000100000079", "0");
        log.info("返回数据："+result);
        result = goodsAPIService.findGoodsByCodeAndType("010036400523", "1");
        log.info("返回数据："+result);
        if(result!=null && !"".equals(result)){
            GoodsBasicDto goodsBaseDto = JSONObject.parseObject(result, GoodsBasicDto.class);
        }
    }
    @Test
    public void insertGoods(){
        TGoodsDto tGoodsDto = new TGoodsDto();
        //tGoodsDto.setGroupid(Long.valueOf("23"));
        tGoodsDto.setType("0");
       // tGoodsDto.setCategoryCode("1111");
        //tGoodsDto.setCategoryName("彩电配件");
        tGoodsService.insertTGoods(tGoodsDto);
    }
}
