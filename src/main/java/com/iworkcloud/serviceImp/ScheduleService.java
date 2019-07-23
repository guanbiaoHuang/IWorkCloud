package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.ScheduleMapper;
import com.iworkcloud.pojo.Schedule;
import com.iworkcloud.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.*;

public class ScheduleService implements IScheduleService {

    private ScheduleMapper scheduleMapper;

    public void setScheduleMapper(ScheduleMapper scheduleMapper) {
        this.scheduleMapper = scheduleMapper;
    }

    @Override
    public boolean addSchedule(Schedule schedule) {
        return 1==scheduleMapper.insertSchedule(schedule)?true:false;
    }

    @Override
    public boolean emptyPastSchedule(String staffId) {
        return 1==scheduleMapper.deleteScheduleByStaffId(staffId)?true:false;
    }

    @Override
    public boolean modifySchedule(Schedule schedule) {
        return 1==scheduleMapper.updateScheduleContent(schedule)?true:false;
    }

    @Override
    public List<Schedule> getRecentSchedule(int recentDays, String staffId) {
        return scheduleMapper.queryScheduleByDays(recentDays,staffId);
    }
}
