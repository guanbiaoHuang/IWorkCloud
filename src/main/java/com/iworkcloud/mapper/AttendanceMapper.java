package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Attendance;

import java.util.Date;
import java.util.List;

public interface AttendanceMapper {
    void insertAttendance(Attendance attendance);
    List<Attendance> queryAttendanceById(int id);
    List<Attendance> queryAttendancesByDate(Date date);

    void deleteAttendanceByDate(Date date);

}

