package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.HolidayMapper;
import com.iworkcloud.pojo.Holiday;
import com.iworkcloud.service.IHolidayService;

import java.util.List;

public class HolidayService implements IHolidayService {

    private HolidayMapper holidayMapper;

    public void setHolidayMapper(HolidayMapper holidayMapper) {
        this.holidayMapper = holidayMapper;
    }

    @Override
    public boolean addHoliday(Holiday holiday) {
        return false;
    }

    @Override
    public boolean ratifyHoliday(long id) {
        return false;
    }

    @Override
    public List<Holiday> getHolidayWaitedRatified() {
        return null;
    }

    @Override
    public List<Holiday> getHolidayWaitedByStaff(String staffId) {
        return null;
    }
}
