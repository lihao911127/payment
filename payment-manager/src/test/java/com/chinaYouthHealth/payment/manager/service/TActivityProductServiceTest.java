package com.chinaYouthHealth.payment.manager.service;

import com.alibaba.fastjson.JSON;
import com.chinaYouthHealth.payment.manager.util.HttpUtil;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Zong on 2017/5/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TActivityProductServiceTest {
    @Autowired
    private TActivityProductService tActivityProductService;

    @Test
    public void getAllTActivityProduct() throws Exception {
        Map<String, Object> allTActivityProduct = tActivityProductService.getAllTActivityProduct();
        List<DiscountDto> discountDtoList = (List<DiscountDto>) allTActivityProduct.get("discounts");
        discountDtoList = discountDtoList.stream()
                .sorted(Comparator.comparing(DiscountDto::getDiscountCode)).collect(Collectors.toList());
        System.out.println("分期产品：" + discountDtoList);
        Assert.assertNotNull(allTActivityProduct);
    }

    @Test
    public void findTActivityProductList() throws Exception {
        String activityCode = "MYF2017000001";
        List<TActivityProduct> tActivityProductList = tActivityProductService.getTActivityProductByActivityCode(activityCode);
        System.out.println(tActivityProductList.size());
        Assert.assertNotNull(tActivityProductList);
    }

    @Test
    public void findTActivityProductByPage() throws Exception {
        TActivityProductSearchDto productSearchDto = new TActivityProductSearchDto();
        productSearchDto.setActivityCode("MYF2017005565");
        PageInfo<ActivityProductDto> tActivityProductByPage = tActivityProductService.findTActivityProductByPage(productSearchDto);
        System.out.println(tActivityProductByPage.getList().size());
        Assert.assertNotNull(tActivityProductByPage);
    }

    @Test
    public void insertTActivityProduct() throws Exception {
        ActivityProductDto productDto = new ActivityProductDto();
        productDto.setProductCode("1");
        productDto.setProductName("产品名称111");
        productDto.setActivityCode("2");
        productDto.setPeriods("18");
        productDto.setToplimit(new BigDecimal(5000));
        tActivityProductService.insertTActivityProduct(productDto);
    }

    @Test
    public void updateTActivityProduct() throws Exception {
        ActivityProductDto activityProductDto = tActivityProductService.findTActivityProductList("1", "2",null).get(0);
        TActivityProduct product = new TActivityProduct();
        BeanUtils.copyProperties(activityProductDto, product);
        System.out.println(JSON.toJSONString(product));

//        product.setId(12L);
        product.setProductCode("1");
        product.setProductName("产品名称222");

        tActivityProductService.updateTActivityProduct(product);
    }

    @Test
    public void deleteTActivityProduct() throws Exception {
        tActivityProductService.deleteTActivityProduct(42L);
    }

    @Test
    public void testCL() {
        String url = "http://10.153.26.40:8888";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateFormat = sdf.format(date); // 日期
        String num = RandomStringUtils.randomNumeric(5); // 5位随机数
//        String param = "{\"SERVICE\":{\"SERVICE_HEADER\":{\"SERVICE_ID\":\"TNQPLPAllLoanPlan\",\"ORG\":\"000000000001\",\"CHANNEL_ID\":\"BANK\",\"ACQ_ID\":\"10000000\",\"SUB_TERMINAL_TYPE\":\"SDK\",\"SERVICESN\":\"SA" + dateFormat + num + "\",\"OP_ID\":null,\"REQUEST_TIME\":\"" + dateFormat + "\",\"VERSION_ID\":\"01\"},\"SERVICE_BODY\":{\"REQUEST\":{\"LOAN_CODE\":\"\"}}}}";
        StringBuffer sb = new StringBuffer();
        sb.append("")
                .append("{")
                .append("    \"SERVICE\":{")
                .append("        \"SERVICE_HEADER\":{")
                .append("            \"SERVICE_ID\":\"TNQPLPAllLoanPlan\",")
                .append("                    \"ORG\":\"000000000001\",")
                .append("                    \"CHANNEL_ID\":\"BANK\",")
                .append("                    \"ACQ_ID\":\"10000000\",")
                .append("                    \"SUB_TERMINAL_TYPE\":\"SDK\",")
                .append("                    \"SERVICESN\":\"SA").append(dateFormat).append(num).append("\",")
                .append("                    \"OP_ID\":null,")
                .append("                    \"REQUEST_TIME\":\"").append(dateFormat).append("\",")
                .append("                    \"VERSION_ID\":\"01\"")
                .append("        },")
                .append("        \"SERVICE_BODY\":{")
                .append("            \"REQUEST\":{")
                .append("                \"LOAN_CODE\":\"\"")
                .append("            }")
                .append("        }")
                .append("    }")
                .append("}");

        String response = HttpUtil.postWithJSON(url, sb.toString());
        Assert.assertNotNull(response);
    }

}