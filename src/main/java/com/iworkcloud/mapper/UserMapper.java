package com.iworkcloud.mapper;

import com.iworkcloud.pojo.User;

public interface UserMapper {
	
	User queryUserByPhone(String phone);
	int addUser(User user);
}
