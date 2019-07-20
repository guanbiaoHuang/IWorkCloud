package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.AttendanceMapper;
import com.iworkcloud.service.IAttendanceService;

public class AttendanceService implements IAttendanceService {

    private AttendanceMapper attendanceMapper;

    public void setAttendanceMapper(AttendanceMapper attendanceMapper) {
        this.attendanceMapper = attendanceMapper;
    }
}
