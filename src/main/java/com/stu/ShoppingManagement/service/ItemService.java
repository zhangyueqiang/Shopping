package com.stu.ShoppingManagement.service;

import com.stu.ShoppingManagement.entity.EUDataGridResult;
import com.stu.ShoppingManagement.entity.ResponseResult;
import com.stu.ShoppingManagement.entity.TbItem;

public interface ItemService {

	TbItem getItemById(long itemId);
	EUDataGridResult getItemList(int page, int rows);
	ResponseResult createItem(TbItem item, String desc, String itemParam) throws Exception;
}
