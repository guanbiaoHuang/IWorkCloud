package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Schedule;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

public interface ScheduleMapper {

    int insertSchedule(Schedule schedule);

    int deleteScheduleByStaffId(String staffId);

    int updateScheduleContent(HashMap<Object,Object>map);

    List<Schedule> queryScheduleByStaffId(String staffId);

    List<Schedule> queryScheduleByTime(HashMap<String, Object> map);

}
