package com.iworkcloud.controller;

import com.iworkcloud.pojo.Bonus;
import com.iworkcloud.serviceImp.BonusService;
import com.iworkcloud.utils.Str2Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@Controller
public class BonusController {
    @Autowired
    private BonusService bonusService;

    @RequestMapping("addBonus")
    public String addBonus(String id,String staff,String time,String mount,String bonusType){

        time = time.replace('T',' ');
        Timestamp timestamp = new Timestamp(Str2Date.getTimeByStr(time));

        bonusService.addBonus(new Bonus(id,staff,timestamp,Double.parseDouble(mount),bonusType));

        return "bill";
    }

}
