package com.iworkcloud.serviceImp;

import com.iworkcloud.pojo.User;
import com.iworkcloud.mapper.UserMapper;
import com.iworkcloud.service.IUserService;

public class UserService implements IUserService {

	private UserMapper userMapper;
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public int register(User user) {
		return userMapper.addUser(user);
		
	}
	@Override
	public String getIcon(String phone) {
		User user = userMapper.queryUserByPhone(phone);
		return null!=user?user.getIcon():"";
	}
	@Override
	public boolean isExist(String phone) {
		return null!=userMapper.queryUserByPhone(phone)?true:false;
	}
	@Override
	public boolean login(String phone, String password) {
		User user = userMapper.queryUserByPhone(phone);
		return (null!=user && user.getPassword().equals(password))?true:false;
	}

	@Override
	public boolean updatePassword(String phone, String password) {
		return 1==userMapper.updatePassword(phone,password);
	}

}
