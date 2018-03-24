package com.stu.ShoppingShow.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stu.ShoppingShow.entity.ResponseResult;
import com.stu.ShoppingShow.entity.TbUser;
import com.stu.ShoppingShow.service.UserService;
import com.stu.ShoppingShow.util.HttpClientUtil;


/**
 * 用户管理Service
 * <p>Title: UserServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月15日上午10:54:10
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Value("${SSO_BASE_URL}")
	public String SSO_BASE_URL;
	@Value("${SSO_DOMAIN_BASE_USRL}")
	public String SSO_DOMAIN_BASE_USRL;
	@Value("${SSO_USER_TOKEN}")
	private String SSO_USER_TOKEN;
	@Value("${SSO_PAGE_LOGIN}")
	public String SSO_PAGE_LOGIN;
	
	
	@Override
	public TbUser getUserByToken(String token) {
		try {
			//调用sso系统的服务，根据token取用户信息
			String json = HttpClientUtil.doGet(SSO_BASE_URL + SSO_USER_TOKEN + token);
			ResponseResult responseResult=null;
			//把json转换成ResponseResult
			ResponseResult result = responseResult.formatToObject(json, TbUser.class);
			if (result.getStatus() == 200) {
				TbUser user = (TbUser) result.getData();
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
