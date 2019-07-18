package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Holiday;

import java.util.HashMap;
import java.util.List;

public interface HolidayMapper {

    int insertHoliday(Holiday holiday);
    int deleteHolidayRecordByStuff(int stuffId);

    List<Holiday> queryHolidayByStuffID(int stuffId);

    int updateHolidayContent(HashMap<Object,Object>map);
}
