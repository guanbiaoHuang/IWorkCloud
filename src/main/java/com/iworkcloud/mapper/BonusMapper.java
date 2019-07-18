package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Bonus;

import java.util.HashMap;
import java.util.List;

public interface BonusMapper {
    int insertBonusRecord(Bonus bonus);

    int updateBonusContent(HashMap<Object,Object>map);

    int deleteBonusRecordById(int id);

    List<Bonus> queryBonusRecordById(int id);

}
