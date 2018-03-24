package com.stu.ShoppingShow.service;

import com.stu.ShoppingShow.entity.TbUser;

public interface UserService {

	TbUser getUserByToken(String token);
}
