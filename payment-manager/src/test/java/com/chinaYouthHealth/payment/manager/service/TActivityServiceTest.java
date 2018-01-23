package com.chinaYouthHealth.payment.manager.service;

import java.util.Date;

import com.chinaYouthHealth.payment.manager.util.JsonUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.gomefinance.promotion.manager.PromotionManagerApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PromotionManagerApplication.class)
public class TActivityServiceTest {
	private static final Logger log = LoggerFactory.getLogger(TActivityServiceImpl.class);
    @Autowired
    private TActivityService tActivityService;
    /**
     * 测试分页查询活动方法
     */
    @Test
    public void queryActivityByPage() {
    	TActivitySearchDto tActivitySearchDto  =  new TActivitySearchDto();
    	tActivitySearchDto.setCurpageNum(1);
    	tActivitySearchDto.setCurpageSize(10);
    	PageInfo<TActivityDto>  page =tActivityService.queryActivityByPage(tActivitySearchDto);
    	log.info(JsonUtils.toJson(page));
        Assert.assertNotNull(page.getList());
    }
    /**
     * 删除活动
     */
    @Test
    public void deleteActivity() {
    	try{
    		String activityCode="MYF2017005645";
    		tActivityService.deleteActivity(activityCode);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    /**
     * 查询活动
     */
    @Test
    public void queryActivity() {
    	try{
    		String activityCode="MYF2017005562";
    		TActivityDto tActivityDto =tActivityService.queryActivity(activityCode);
    		log.info(JsonUtils.toJson(tActivityDto));
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    /**
     * 更新活动
     */
    @Test
    public void updateActivity() {
    	try{
    		TActivityDto  tActivity =  new TActivityDto();
    		tActivity.setActivityCode("MYF2017005562");
    		tActivityService.updateActivity(tActivity);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    /**
     * 新增活动
     */
    @Test
    public void insertActivity() {
    	try{
    		TActivityDto  tActivity =  new TActivityDto();
    		tActivity.setActivityName("接口测试111");
    		tActivity.setCreatetime(new Date());
    		tActivity.setStartTime("2016-05-16 07:52:48");
    		tActivity.setEndTime("2016-05-16 07:52:48");
    		tActivity.setPriority("1");
    		tActivity.setGroupid(1l);
    		tActivity.setActivityFlag("0");
    		tActivityService.insertActivity(tActivity);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

   

}
