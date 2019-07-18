package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Holiday;

import java.util.HashMap;
import java.util.List;

public interface HolidayMapper {

    void insertHoliday(Holiday holiday);
    void deleteHolidayRecordByStuff(int stuffId);

    List<Holiday> queryHolidayByStuffID(int stuffId);

    void updateHolidayContent(HashMap<Object,Object>map);
}
