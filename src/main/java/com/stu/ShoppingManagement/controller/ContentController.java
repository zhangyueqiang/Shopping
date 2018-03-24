package com.stu.ShoppingManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stu.ShoppingManagement.entity.ResponseResult;
import com.stu.ShoppingManagement.entity.TbContent;
import com.stu.ShoppingManagement.service.ContentService;


/**
 * 内容管理Controller
 * <p>Title: ContentController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 */
@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/save")
	@ResponseBody
	public ResponseResult insertContent(TbContent content) {
		ResponseResult result = contentService.insertContent(content);
		return result;
	}
}
