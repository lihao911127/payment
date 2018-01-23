package com.chinaYouthHealth.payment.manager.service;

import java.util.ArrayList;
import java.util.List;

import com.chinaYouthHealth.payment.manager.util.JsonUtils;
import com.chinaYouthHealth.payment.manager.util.UserConstatnt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.gomefinance.promotion.manager.PromotionManagerApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PromotionManagerApplication.class)
public class AclUserServiceTest {
	private static final Logger log = LoggerFactory.getLogger(AclUserServiceTest.class);
	@Autowired
	private AclUserService  aclUserService;
	/**
	 * 通过姓名查询用户
	 */
	@Test
	public   void  findAclUserByName(){
		AclUser aclUser =aclUserService.findAclUserByName("test1");
		log.info(JsonUtils.toJson(aclUser));
	}
	/**
	 * 分页查询用户
	 */
	@Test
	public  void  getAclUserByPage(){
		PageInfo<AclUserDto>  page =aclUserService.getAclUserByPage(1, 10);
		log.info(JsonUtils.toJson(page));
	}
	/**
	 * 新增用户
	 */
	@Test
	public  void  addUser(){

		AclUserDto aclUser  =  new  AclUserDto();
		aclUser.setIdcard("1111");
		aclUser.setMobile("15011111111");
		aclUser.setRealname("测试");
		aclUser.setIslock(UserConstatnt.ACLUSER_ISLOCK_NO);
		aclUser.setPeopletype(UserConstatnt.PEOPLETYPE_MERCHANT);
		aclUser.setUserName("bahe");
		ShaPasswordEncoder encoder = new ShaPasswordEncoder();
		String hPassword = encoder.encodePassword("bahe123", aclUser.getUserName());
		aclUser.setUserPwd(hPassword);
		aclUser.setRoleIds("1");

		int  ss =aclUserService.addUser(aclUser);
		log.info(String.valueOf(ss));
	}
	/***
	 * 忘记密码测试
	 */
	@Test
	public  void  forgetpassword(){
		aclUserService.forgetpassword("测试", "15001327397", "1111", "22222");
	}
	/**
	 * 修改手机号
	 */
	@Test
	public  void  updateMobile(){
		aclUserService.updateMobile("22222", "15001327397", "15001327399");
	}
	/**
	 * 修改密码
	 */
	@Test
	public  void  updatePassword(){
		aclUserService.updatePassword("15001327399", "22222", "11111");
	}
	/**
	 * 重置密码
	 */
	@Test
	public  void  resetPwd(){
		aclUserService.resetPwd(264, "264264");
	}
	/**
	 * 锁定用户
	 */
	@Test
	public   void  lockUserByMobile(){
		aclUserService.lockUserByMobile("15001327399");
	}
	/**
	 * 解锁用户
	 */
	@Test
	public   void  unLockUserByMobile(){
		aclUserService.unLockUserByMobile("15001327399");
	}
	/**
	 * 更新身份证和手机号
	 */
	@Test
	public   void  updateRenameAndidCard(){
		aclUserService.updateRenameAndidCard("测试", "1111", "15001327399");
	}
	@Test
	public  void  selectByPrimaryKey(){
		AclUser  aclUser =aclUserService.selectByPrimaryKey(264);
		log.info(JsonUtils.toJson(aclUser));
	}
	@Test
	public  void  updateUserEntity(){
		AclUserDto aclUser  =  new AclUserDto();
		aclUser.setId(264);
		aclUserService.updateUserEntity(aclUser);
	}
	@Test
	public  void  queryAclUserByMobiles(){
		List<String> mobiles  =  new ArrayList<String>();
		mobiles.add("15001327399");
		mobiles.add("15001327397");
		List<AclUser> list =aclUserService.queryAclUserByMobiles(mobiles);
		log.info(JsonUtils.toJson(list));
	}
	@Test
	public  void  queryAllUserByResponserMobile(){
		List<AclUser> list =aclUserService.queryAllUserByResponserMobile("15001327399");
		log.info(JsonUtils.toJson(list));
	}
	@Test
	public  void  vertifyidNumber(){
		List<AclUser> list =aclUserService.vertifyidNumber("1111");
		log.info(JsonUtils.toJson(list));
	}
	@Test
	public  void  findAclUserByusernameAndpassword(){
		AclUser aclUser =aclUserService.findAclUserByusernameAndpassword("测试","2222");
		log.info(JsonUtils.toJson(aclUser));
	}
	@Test
	public  void  queryAclUserByMobile(){
		AclUserDto aclUser =aclUserService.queryAclUserByMobile("15001327399");
		log.info(JsonUtils.toJson(aclUser));
	}
	@Test
	public  void  deleteUserByUserName(){
		aclUserService.deleteUserByUserName("测试");
	}
	@Test
	public  void  getAclUserListByRoleid(){
		List<AclUser> list =aclUserService.getAclUserListByRoleid("1");
		log.info(JsonUtils.toJson(list));
	}
	@Test
	public  void  queryAclUserListByName(){
		List<AclUser> list =aclUserService.queryAclUserListByName("15001327397");
		log.info(JsonUtils.toJson(list));
	}
	/***
	 * 通过名字和电话号码查询人员信息
	 */
	@Test
	public  void  queryByNameOrPhNum(){
		PageInfo<AclUserDto> page =aclUserService.queryByNameOrPhNum("150",1,10);
		log.info(JsonUtils.toJson(page));
	}
}
