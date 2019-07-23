package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.AttendanceMapper;
import com.iworkcloud.pojo.Attendance;
import com.iworkcloud.pojo.Staff;
import com.iworkcloud.service.IAttendanceService;

import java.sql.Date;
import java.util.List;

public class AttendanceService implements IAttendanceService {

    private AttendanceMapper attendanceMapper;

    public void setAttendanceMapper(AttendanceMapper attendanceMapper) {
        this.attendanceMapper = attendanceMapper;
    }

    @Override
    public boolean addAttendance(Attendance attendance) {
        return 1==attendanceMapper.insertAttendance(attendance)?true:false;
    }

    @Override
    public boolean getAbsenceByDay() {
        return false;
    }



    @Override
    public boolean getAttendanceByStaff(String staffId) {
        return false;
    }

    @Override
    public List<Attendance> getAttendanceToday() {
        return attendanceMapper.queryAllAttendanceToday();
    }

}
