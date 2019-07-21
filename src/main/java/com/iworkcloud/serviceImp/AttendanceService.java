package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.AttendanceMapper;
import com.iworkcloud.pojo.Attendance;
import com.iworkcloud.service.IAttendanceService;

import java.sql.Date;

public class AttendanceService implements IAttendanceService {

    private AttendanceMapper attendanceMapper;

    public void setAttendanceMapper(AttendanceMapper attendanceMapper) {
        this.attendanceMapper = attendanceMapper;
    }

    @Override
    public boolean addAttendance(Attendance attendance) {
        return false;
    }

    @Override
    public boolean getAbsenceByDay(Date date) {
        return false;
    }

    @Override
    public boolean getAttendanceByStaff(String staffId) {
        return false;
    }
}
