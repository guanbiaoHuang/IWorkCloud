package com.iworkcloud.service;

import com.iworkcloud.pojo.Bonus;

public interface IBonusService {
    //添加奖金或补贴
    boolean addBonus(Bonus bonus);
    //修改奖金或补贴
    boolean modifyBonus(Bonus bonus);
}
