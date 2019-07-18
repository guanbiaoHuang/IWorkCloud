package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Attendance;

import java.util.Date;

public interface AttendanceMapper {
    void insertAttendance(Attendance attendance);
    Attendance queryAttendanceById(int id);
    Attendance queryAttendancesByDate(Date date);


}

