package com.stu.ShoppingManagement.service;

import com.stu.ShoppingManagement.entity.ResponseResult;
import com.stu.ShoppingManagement.entity.TbItemParam;

public interface ItemParamService {

	ResponseResult getItemParamByCid(long cid);
	ResponseResult insertItemParam(TbItemParam itemParam);
}

