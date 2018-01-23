package com.chinaYouthHealth.payment.manager.service;

import com.gomefinance.promotion.api.PromotionAPIService;
import com.gomefinance.promotion.dto.ActivityApiDto;
import com.gomefinance.promotion.dto.GoodsApiDto;
import com.gomefinance.promotion.dto.ProductApiDto;
import com.gomefinance.promotion.dto.ProductDetailApiDto;
import com.chinaYouthHealth.payment.manager.util.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gomefinance.promotion.manager.PromotionManagerApplication;

import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PromotionManagerApplication.class)
public class TCodeServiceTest {
	private static final Logger log = LoggerFactory.getLogger(TCodeServiceTest.class);
    @Autowired
    private TCodeService tCodeService;
    @Autowired
    private PromotionAPIService promotionAPIService;
    /**
     * 测试分页查询活动方法
     */
    @Test
    public void queryActivityByPage() {
    	for(int i=0;i<100;i++){
            //List<ActivityApiDto> list = promotionAPIService.findActivityList("1", "S0O5");
            //List<ProductApiDto> list = promotionAPIService.findActivityProductSet("2", "MYF2017005574");
            //List<ProductDetailApiDto> list = promotionAPIService.findProductDetailList("MYFEN", "6601");
            GoodsApiDto list = promotionAPIService.findGoods("1", "", "100000071", null);
            log.info("返回的活动：" + JsonUtils.toJson(list));
    	}
    }

    /**
	 * 并发测试
     * @throws Throwable 
	 */
    @Test 
    public void MultiRequestsTest() throws Throwable{ 
                // 构造一个Runner 
        TestRunnable runner = new TestRunnable() { 
            @Override 
            public void runTest() throws Throwable { 
            	queryActivityByPage();
            } 
        };
        try {
            int runnerCount =400;
            //Rnner数组，想当于并发多少个。
            TestRunnable[] trs = new TestRunnable[runnerCount];
            for (int i = 0; i < runnerCount; i++) {
                trs[i] = runner;
            }
                    // 用于执行多线程测试用例的Runner，将前面定义的单个Runner组成的数组传入
            MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);

                        // 开发并发执行数组里定义的内容 
            mttr.runTestRunnables(); 
        } catch (Exception e) { 
            log.info(e.getMessage());
        } 
    }


}
