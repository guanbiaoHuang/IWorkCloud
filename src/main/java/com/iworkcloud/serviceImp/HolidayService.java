package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.HolidayMapper;
import com.iworkcloud.service.IHolidayService;

public class HolidayService implements IHolidayService {

    private HolidayMapper holidayMapper;

    public void setHolidayMapper(HolidayMapper holidayMapper) {
        this.holidayMapper = holidayMapper;
    }
}
