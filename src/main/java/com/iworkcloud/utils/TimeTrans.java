package com.iworkcloud.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

public class TimeTrans {

    public static HashMap<String,Object>getRecentDays(int days){
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
        calendar.add(Calendar.DATE,days);
        HashMap<String,Object> map = new HashMap<>();
        map.put("timeStart",new Timestamp(System.currentTimeMillis()));
        map.put("timeEnd",new Timestamp(calendar.getTimeInMillis()));

        return map;
    }
}
