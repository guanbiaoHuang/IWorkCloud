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
        return 1==holidayMapper.insertHoliday(holiday)? true:false;
    }

    @Override
    public boolean ratifyHoliday(String staffId) {
        return 1==holidayMapper.refuseHoliday(staffId)?true:false;
    }

    @Override
    public List<Holiday> getHolidayWaitedRatified() {
        return holidayMapper.queryHolidayByRatifyStatus();
    }

    @Override
    public List<Holiday> getHolidayWaitedByStaff(String staffId) {
        return holidayMapper.queryHolidayByStaffID(staffId);
    }
}
