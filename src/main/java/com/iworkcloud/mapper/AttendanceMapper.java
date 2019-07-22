package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Attendance;

import java.util.Date;
import java.util.List;

public interface AttendanceMapper {
    int insertAttendance(Attendance attendance);

    List<Attendance> queryAttendanceToday(String staffId);

    List<Attendance> queryAllAttendanceToday();

    List<Attendance> getAttendanceMonth(String staffId);

}

