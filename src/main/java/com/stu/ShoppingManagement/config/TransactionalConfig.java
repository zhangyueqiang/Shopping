package com.stu.ShoppingManagement.config;

import java.util.Properties;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/*
 * 事务管理配置，未测试是否有效
 * 
 */

@Configuration
public class TransactionalConfig {

	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	 @Bean(name = "txAdvice")
	 public TransactionInterceptor getAdvisor() throws Exception {
		 
	     Properties properties = new Properties();
	     properties.setProperty("get*", "PROPAGATION_SUPPORTS,-Exception,readOnly");
	     properties.setProperty("select*", "PROPAGATION_SUPPORTS,-Exception,readOnly");
	     properties.setProperty("find*", "PROPAGATION_SUPPORTS,-Exception,readOnly");
	     properties.setProperty("add*", "PROPAGATION_REQUIRED,-Exception");
	     properties.setProperty("insert*", "PROPAGATION_REQUIRED,-Exception");
	     properties.setProperty("create*", "PROPAGATION_REQUIRED,-Exception");
	     properties.setProperty("save*", "PROPAGATION_REQUIRED,-Exception");
	     properties.setProperty("update*", "PROPAGATION_REQUIRED,-Exception");
	     properties.setProperty("delete*", "PROPAGATION_REQUIRED,-Exception");
	 
	     TransactionInterceptor tsi = new TransactionInterceptor(transactionManager,properties);
	     return tsi;
	 
	  }	  
	 
	  @Bean
	  public BeanNameAutoProxyCreator txProxy() {
	      BeanNameAutoProxyCreator creator = new BeanNameAutoProxyCreator();
	      creator.setInterceptorNames("txAdvice");
	      creator.setBeanNames("*Service", "*ServiceImpl");
	      creator.setProxyTargetClass(true);
	      return creator;
	  }	
	
}
