package com.iworkcloud.service;

import com.iworkcloud.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface IUserService {

    int register(User user);
    String getIcon(String phone);
    boolean isExist(String phone);
    boolean login(String phone, String password);

    boolean updatePassword(String phone,String password);
}
