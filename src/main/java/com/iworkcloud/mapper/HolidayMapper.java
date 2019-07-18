package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Holiday;

import java.util.HashMap;
import java.util.List;

public interface HolidayMapper {

    int insertHoliday(Holiday holiday);
    int deleteHolidayRecordByStaff(int staffId);

    List<Holiday> queryHolidayByStaffID(int staffId);

    int updateHolidayContent(HashMap<Object,Object>map);
}
