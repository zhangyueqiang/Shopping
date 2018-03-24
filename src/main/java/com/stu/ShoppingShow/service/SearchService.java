package com.stu.ShoppingShow.service;

import com.stu.ShoppingShow.entity.SearchResult;

public interface SearchService {

	SearchResult search(String queryString, int page);
}
