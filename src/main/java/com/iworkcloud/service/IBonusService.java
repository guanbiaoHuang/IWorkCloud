package com.iworkcloud.service;

import com.iworkcloud.pojo.Bonus;

import java.util.List;

public interface IBonusService {
    //添加奖金或补贴
    boolean addBonus(Bonus bonus);
    //查询某员工所有奖金记录
    List<Bonus> queryAllBonus(String staffId);
}
