package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Bonus;

import java.util.HashMap;

public interface BonusMapper {
    void insertBonusRecord(Bonus bonus);

    void updateBonusContent(HashMap<Object,Object>map);

    void deleteBonusRecordById(int id);

    Bonus queryBonusRecordById(int id);

}
