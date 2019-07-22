package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Bonus;

import java.util.HashMap;
import java.util.List;

public interface BonusMapper {

    int insertBonus(Bonus bonus);

    int updateBonusContent(HashMap<Object,Object>map);

    int deleteBonusById(int id);

    List<Bonus> queryAllBonus();

}
