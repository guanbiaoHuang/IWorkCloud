package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.BonusMapper;
import com.iworkcloud.pojo.Bonus;
import com.iworkcloud.pojo.Staff;
import com.iworkcloud.service.IBonusService;
import com.iworkcloud.utils.ExcelUtil;
import com.iworkcloud.utils.Str2Date;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
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

    @Override
    public boolean addBonusByExcel(MultipartFile file) {
        InputStream inputStream = null;
        List<List<Object>> lists = null;
        try {
            inputStream = file.getInputStream();
            lists = new ExcelUtil().getBankListByExcel(inputStream,file.getOriginalFilename());
            for (int i = 0; i<lists.size();i++){
                List<Object> list = lists.get(i);
                Bonus bonus = new Bonus(String.valueOf(list.get(0)),
                                        String.valueOf(list.get(1)),
                        new Timestamp(Str2Date.getTimeByStr(String.valueOf(list.get(3)))),
                        Double.parseDouble(String.valueOf(list.get(2))),
                                        String.valueOf(list.get(4)));
                bonusMapper.insertBonus(bonus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (inputStream!=null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    @Override
    public List<Bonus> queryBonusNumOrderByMonth(String tag) {
        return bonusMapper.queryBonusNumOrderByMonth(staff);
    }
}
