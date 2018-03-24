package com.stu.ShoppingShow.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.ShoppingShow.entity.CartItem;
import com.stu.ShoppingShow.entity.ResponseResult;


public interface CartService {

	ResponseResult addCartItem(long itemId, int num, HttpServletRequest request, HttpServletResponse response);
	List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response);
	ResponseResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);
}
