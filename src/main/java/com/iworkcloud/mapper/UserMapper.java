package com.iworkcloud.mapper;

import com.iworkcloud.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	
	User queryUserByPhone(String phone);
	int addUser(User user);

	int updatePassword(@Param("phone")String phone, @Param("password") String password);
}
