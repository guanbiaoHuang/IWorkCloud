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

    int updateScheduleContent(Schedule schedule);

    List<Schedule>queryScheduleByDays(@Param("days")int days,@Param("staffId")String staffId);


}
