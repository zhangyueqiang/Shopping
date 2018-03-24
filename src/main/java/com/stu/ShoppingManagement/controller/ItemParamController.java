package com.stu.ShoppingManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stu.ShoppingManagement.entity.ResponseResult;
import com.stu.ShoppingManagement.entity.TbItemParam;
import com.stu.ShoppingManagement.service.ItemParamService;


/**
 * 商品规格参数模板管理Controller
 * <p>Title: ItemParamController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {

	@Autowired
	private ItemParamService itemParamService;
	
	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public ResponseResult getItemParamByCid(@PathVariable Long itemCatId) {
		ResponseResult result = itemParamService.getItemParamByCid(itemCatId);
		return result;
	}
	
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public ResponseResult insertItemParam(@PathVariable Long cid, String paramData) {
		//创建entity对象
		TbItemParam itemParam = new TbItemParam();
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		ResponseResult result = itemParamService.insertItemParam(itemParam);
		return result;
	}
}
