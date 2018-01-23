package com.chinaYouthHealth.payment.manager.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.gomefinance.promotion.manager.PromotionManagerApplication;
import com.chinaYouthHealth.payment.manager.util.JsonUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PromotionManagerApplication.class)
public class StationServiceTest {
	private static final Logger log = LoggerFactory.getLogger(StationServiceTest.class);

	@Autowired
	private  StationService  stationService;
	/**
	 * 查询全部岗位
	 */
	@Test
    public void queryAllStation() {
		PageInfo<StationDto>  list =stationService.queryAllStation(1, 10);
		log.info(JsonUtils.toJson(list));
    }
	/**
	 * 查询岗位名称，模糊查询
	 */
	@Test
    public void queryByRoleName() {
		PageInfo<StationDto>  list =stationService.queryByRoleName("测试", 1, 10);
		log.info(JsonUtils.toJson(list));
    }
	/**
	 * 新增岗位
	 */
	@Test
	public void addStation(){
		String[]  ids={"1","2","3"};
		stationService.addStation("测试",1, ids, 1);
	}
	/**
	 * 修改岗位管理
	 */
	@Test
	public   void  modifyStation(){
		String[]  ids={"1","2","3"};
		stationService.modifyStation(156, "修改角色", 1, ids, 1);
	}
	/**
	 * 删除岗位
	 */
	@Test
	public  void  deleteStation(){
		stationService.deleteStation(156, 2);
	}
	/**
	 * 查询岗位权限
	 */
	@Test
	public  void queryDetailById(){
		RoleSourcesDto roleSourcesDto=stationService.queryDetailById(156);
		log.info("岗位权限"+JsonUtils.toJson(roleSourcesDto));
	}
	/**
	 * 查询系统所有岗位权限
	 */
	@Test
	public  void queryAllRole(){
		List<StationDto> list=stationService.queryAllRole();
		log.info("岗位权限"+JsonUtils.toJson(list));
	}
	/**
	 * 查询岗位权限
	 */
	@Test
	public  void queryRDetailById(){
		StationDto stationDto =stationService.queryRDetailById(156);
		log.info("岗位权限"+JsonUtils.toJson(stationDto));
	}
	/**
	 * 修改岗位信息
	 */
	@Test
	public   void  updateUserNumber(){
		StationDto record  =  new StationDto();
		record.setUser_number(3);
		record.setId(156);
	    stationService.updateUserNumber(record);
	}
	/**
	 * 获取岗位
	 */
	@Test
	public  void  selectByPrimaryKey(){
		StationDto  stationDto  =stationService.selectByPrimaryKey(156);
		log.info(JsonUtils.toJson(stationDto));
	}
	/**
	 * 获取
	 */
	@Test
	public   void  allAuth(){
		List<MenuDto>  list =stationService.allAuth();
		log.info(JsonUtils.toJson(list));
	}
	/**
	 * 获取岗位人下面所有的员工
	 */
	@Test
	public   void queryUserByResponseId(){
		List<StationDto>  list =stationService.queryUserByResponseId(1);
		log.info(JsonUtils.toJson(list));
	}
}
