package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Holiday;

import java.util.List;

public interface HolidayMapper {

    int insertHoliday(Holiday holiday);

    List<Holiday> queryHolidayByStaffID(String staffId);

    List<Holiday> queryHolidayByRatifyStatus();

    int ratifyHoliday(String staffID);

    int refuseHoliday(String staffID);
}
