package com.chinaYouthHealth.payment.manager.service;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public class TestPassword {
	private static final Logger log = LoggerFactory.getLogger(AclUserServiceTest.class);
	/**
	 * 测试密码加密
	 * @param args
	 */
	public static void main(String[] args) {
		ShaPasswordEncoder encoder = new ShaPasswordEncoder();
		log.info(encoder.encodePassword("123456", " wsx12345"));
		log.info(decodeBase64("MTIzNDU2"));
		log.info(encodeBase64("123456"));
	}
	/**
	 * 测试密码解密
	 * @param password
	 * @return
	 */
	public static String decodeBase64(String password){
		return  new String(Base64.decodeBase64(password));
	}
	/**
	 * 密码加密
	 * @param password
	 * @return
	 */
	public  static String encodeBase64(String password){
		return  new String(Base64.encodeBase64(password.getBytes()));
	}
}
