/*package com.gomefinance.promotion.manager.config.druid;  
  
import lombok.extern.slf4j.Slf4j;  
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Before;  
import org.springframework.stereotype.Component;

import DataSourceContextHolder;
  
*//** 
 * Created by huguoju on 2016/12/29. 
 * 拦截设置本地线程变量 
 *//*  
@Aspect  
@Component  
@Slf4j  
public class DataSourceAop {  
    @Before("execution(* com.gomefinance.promotion.manager.mapper..*.select*(..)) || execution(* com.gomefinance.promotion.manager.mapper..*.get*(..))")  
    public void setReadDataSourceType() {  
        DataSourceContextHolder.read();  
        log.info("dataSource切换到：Read");  
    }  
  
    @Before("execution(* com.gomefinance.promotion.manager.mapper..*.insert*(..)) || execution(* com.gomefinance.promotion.manager.mapper..*.update*(..))")  
    public void setWriteDataSourceType() {  
        DataSourceContextHolder.write();  
        log.info("dataSource切换到：write");  
    }  
}  */