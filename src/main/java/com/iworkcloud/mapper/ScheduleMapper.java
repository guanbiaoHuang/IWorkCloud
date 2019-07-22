package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Schedule;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

public interface ScheduleMapper {

    int insertSchedule(Schedule schedule);

    int deleteScheduleByStaffId(String staffId);

    int updateScheduleContent(HashMap<Object,Object>map);

    List<Schedule>queryScheduleByDays(@Param("days")int days,@Param("staffId")String staffId);

    List<Schedule>queryScheduleByTime(HashMap<Object,Object>map);

}
