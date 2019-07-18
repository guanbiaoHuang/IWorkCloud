package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Schedule;

import java.util.HashMap;
import java.util.List;

public interface ScheduleMapper {

    int insertSchedule(Schedule schedule);

    int deleteScheduleByStaffId(String staffId);

    int updateScheduleContent(HashMap<Object,Object>map);

    List<Schedule>queryScheduleByStaffId(String staffId);
}
