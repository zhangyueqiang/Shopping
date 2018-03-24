package com.stu.ShoppingShow.service;

import com.stu.ShoppingShow.entity.ItemInfo;

public interface ItemService {

	ItemInfo getItemById(Long itemId);
	String getItemDescById(Long itemId);
	String getItemParam(Long itemId);
	
}
