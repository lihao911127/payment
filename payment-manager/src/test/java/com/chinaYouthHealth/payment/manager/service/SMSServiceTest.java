package com.chinaYouthHealth.payment.manager.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gomefinance.promotion.manager.PromotionManagerApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PromotionManagerApplication.class)
public class SMSServiceTest {
	@Autowired
	private  SMSService  sMSService;
	@Test
    public void queryActivityByPage() {
		sMSService.send("15001327397", "测试短信接口");
    }
}
