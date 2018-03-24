package com.stu.ShoppingManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stu.ShoppingManagement.entity.EUTreeNode;
import com.stu.ShoppingManagement.service.ItemCatService;


/**
 * 商品分类管理controller
 * <p>Title: ItemCatController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 

 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/list")
	@ResponseBody
	private List<EUTreeNode> getCatList(@RequestParam(value="id",defaultValue="0")Long parentId) {
		List<EUTreeNode> list = itemCatService.getCatList(parentId);
		return list;
	}
}
