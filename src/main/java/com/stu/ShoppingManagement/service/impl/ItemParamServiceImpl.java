package com.stu.ShoppingManagement.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stu.ShoppingManagement.entity.ResponseResult;
import com.stu.ShoppingManagement.entity.TbItemParam;
import com.stu.ShoppingManagement.entity.TbItemParamExample;
import com.stu.ShoppingManagement.entity.TbItemParamExample.Criteria;
import com.stu.ShoppingManagement.mapper.TbItemParamMapper;
import com.stu.ShoppingManagement.service.ItemParamService;


/**
 * 商品规格参数模板管理
 * <p>Title: ItemParamServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 */
@Service
@Transactional
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamMapper itemParamMapper;
	
	@Override
	public ResponseResult getItemParamByCid(long cid) {
		TbItemParamExample example = new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
		//判断是否查询到结果
		if (list != null && list.size() > 0) {
			return ResponseResult.ok(list.get(0));
		}
		
		return ResponseResult.ok();
	}

	@Override
	public ResponseResult insertItemParam(TbItemParam itemParam) {
		//补全pojo
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		//插入到规格参数模板表
		itemParamMapper.insert(itemParam);
		return ResponseResult.ok();
	}

}
