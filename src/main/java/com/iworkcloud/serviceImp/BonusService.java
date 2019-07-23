package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.BonusMapper;
import com.iworkcloud.pojo.Bonus;
import com.iworkcloud.service.IBonusService;

import java.util.List;

public class BonusService implements IBonusService {

    private BonusMapper bonusMapper;

    public void setBonusMapper(BonusMapper bonusMapper) {
        this.bonusMapper = bonusMapper;
    }

    @Override
    public boolean addBonus(Bonus bonus) {
        return 1==bonusMapper.insertBonus(bonus)?true:false;
    }


    @Override
    public List<Bonus> queryAllBonus(String staffId) {
        return bonusMapper.queryAllBonus(staffId);
}
}
