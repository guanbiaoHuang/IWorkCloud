package com.iworkcloud.service;

import com.iworkcloud.pojo.Holiday;

import java.util.List;

public interface IHolidayService {

    boolean addHoliday(Holiday holiday);
    boolean ratifyHoliday(String staffId);
    List<Holiday> getHolidayWaitedRatified();
    List<Holiday> getHolidayWaitedByStaff(String staffId);

}
