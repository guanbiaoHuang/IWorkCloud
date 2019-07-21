package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.BonusMapper;
import com.iworkcloud.pojo.Bonus;
import com.iworkcloud.service.IBonusService;

public class BonusService implements IBonusService {

    private BonusMapper bonusMapper;

    public void setBonusMapper(BonusMapper bonusMapper) {
        this.bonusMapper = bonusMapper;
    }

    @Override
    public boolean addBonus(Bonus bonus) {
        return false;
    }

    @Override
    public boolean modifyBonus(Bonus bonus) {
        return false;
    }
}
