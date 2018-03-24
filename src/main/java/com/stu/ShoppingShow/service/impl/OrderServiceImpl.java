package com.stu.ShoppingShow.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stu.ShoppingShow.entity.Order;
import com.stu.ShoppingShow.entity.ResponseResult;
import com.stu.ShoppingShow.service.OrderService;
import com.stu.ShoppingShow.util.HttpClientUtil;
import com.stu.ShoppingShow.util.JsonUtil;


/**
 * 订单处理Service
 * <p>Title: OrderServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月16日下午2:45:08
 * @version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;
	

	@Override
	public String createOrder(Order order) {
		//调用创建订单服务之前补全用户信息。
		//从cookie中后取TT_TOKEN的内容，根据token调用sso系统的服务根据token换取用户信息。
		
		//调用Response-order的服务提交订单。
		String json = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_CREATE_URL, JsonUtil.objectToJson(order));
		ResponseResult responseResult=null;
		//把json转换成ResponseResult
		ResponseResult ResponseResult = responseResult.format(json);
		if (ResponseResult.getStatus() == 200) {
			Object orderId = ResponseResult.getData();
			return orderId.toString();
		}
		return "";
	}

}