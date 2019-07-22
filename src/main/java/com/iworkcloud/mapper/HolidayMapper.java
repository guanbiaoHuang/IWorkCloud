package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Holiday;

import java.util.HashMap;
import java.util.List;

public interface HolidayMapper {

    int insertHoliday(Holiday holiday);

    List<Holiday> queryHolidayByStaffID(String staffId);

    List<Holiday> queryHolidayByRatifyStatus();

    int updateHolidayContent(HashMap<Object,Object>map);

    int refuseHoliday(String staffID);
}
