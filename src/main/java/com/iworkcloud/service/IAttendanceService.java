package com.iworkcloud.service;

import com.iworkcloud.pojo.Attendance;

import java.sql.Date;

public interface IAttendanceService {

    boolean addAttendance(Attendance attendance);
    boolean getAbsenceByDay(Date date);
    boolean getAttendanceByStaff(String staffId);

}
