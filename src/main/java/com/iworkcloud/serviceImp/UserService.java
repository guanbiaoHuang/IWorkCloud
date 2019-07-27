package com.iworkcloud.serviceImp;

import com.iworkcloud.pojo.User;
import com.iworkcloud.mapper.UserMapper;
import com.iworkcloud.service.IUserService;

public class UserService implements IUserService {

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public int register(User user) {
        return userMapper.addUser(user);

    }

    /**
     * 获取头像地址
     * @param phone
     * @return
     */
    @Override
    public String getIcon(String phone) {
        User user = userMapper.queryUserByPhone(phone);
        return null != user ? user.getIcon() : "";
    }

    /**
     * 判断用户是否已经注册
     * @param phone 手机号
     * @return
     */
    @Override
    public boolean isExist(String phone) {
        return null != userMapper.queryUserByPhone(phone);
    }

    /**
     * 登陆
     * @param phone 手机号
     * @param password 密码
     * @return
     */
    @Override
    public boolean login(String phone, String password) {
        User user = userMapper.queryUserByPhone(phone);
        return null != user && user.getPassword().equals(password);
    }

    /**
     * 修改账号密码
     * @param phone 手机号
     * @param password 密码
     * @return
     */
    @Override
    public boolean updatePassword(String phone, String password) {
        return 1 == userMapper.updatePassword(phone, password);
    }

}
