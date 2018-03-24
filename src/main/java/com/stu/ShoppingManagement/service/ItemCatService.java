package com.stu.ShoppingManagement.service;

import java.util.List;

import com.stu.ShoppingManagement.entity.EUTreeNode;


public interface ItemCatService {

	List<EUTreeNode> getCatList(long parentId);
}
