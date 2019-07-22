package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Attendance;

import java.util.Date;
import java.util.List;

public interface AttendanceMapper {
    int insertAttendance(Attendance attendance);
    List<Attendance> queryAttendanceByStaff(String staffId);
    List<Attendance> queryAttendancesByDate(Date date);

}

