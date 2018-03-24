package com.stu.ShoppingShow.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stu.ShoppingShow.entity.ResponseResult;
import com.stu.ShoppingShow.entity.SearchResult;
import com.stu.ShoppingShow.service.SearchService;
import com.stu.ShoppingShow.util.HttpClientUtil;

/**
 * 商品搜索Service
 * <p>Title: SearchServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月12日上午9:11:58
 * @version 1.0
 */

@Service
public class SearchServiceImpl implements SearchService {

	@Value("${SEARCH_BASE_URL}")
	private String SEARCH_BASE_URL;
	
	@Override
	public SearchResult search(String queryString, int page) {
		// 调用Response-search的服务
		//查询参数
		Map<String, String> param = new HashMap<>();
		param.put("q", queryString);
		param.put("page", page + "");
		try {
			//调用服务
			String json = HttpClientUtil.doGet(SEARCH_BASE_URL, param);
			ResponseResult responseResult=null;
			//把字符串转换成java对象
			ResponseResult ResponseResult = responseResult.formatToObject(json, SearchResult.class);
			if (ResponseResult.getStatus() == 200) {
				SearchResult result = (SearchResult) ResponseResult.getData();
				return result;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
