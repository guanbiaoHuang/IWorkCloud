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
        return false;
    }

    @Override
    public boolean modifySchedule(Schedule schedule) {
        return false;
    }

    @Override
    public List<Schedule> getRecentSchedule(int recentDays, String staffId) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
        calendar.add(Calendar.DATE,7);
        HashMap<String,Object> map = new HashMap<>();
        map.put("timeNow",new Timestamp(System.currentTimeMillis()));
        map.put("finalTime",new Timestamp(calendar.getTimeInMillis()));
        map.put("staffId",staffId);
        return scheduleMapper.queryScheduleByTime(map);
    }
}
