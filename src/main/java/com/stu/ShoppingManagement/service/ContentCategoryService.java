package com.stu.ShoppingManagement.service;

import java.util.List;

import com.stu.ShoppingManagement.entity.EUTreeNode;
import com.stu.ShoppingManagement.entity.ResponseResult;


public interface ContentCategoryService {

	List<EUTreeNode> getCategoryList(long parentId);
	ResponseResult insertContentCategory(long parentId, String name);
}
