package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.AttendanceMapper;
import com.iworkcloud.mapper.StaffMapper;
import com.iworkcloud.pojo.Attendance;
import com.iworkcloud.pojo.Staff;
import com.iworkcloud.service.IAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;

public class AttendanceService implements IAttendanceService {


    private AttendanceMapper attendanceMapper;

    public void setAttendanceMapper(AttendanceMapper attendanceMapper) {
        this.attendanceMapper = attendanceMapper;
    }

    /**
     *添加出勤信息
     * @param attendance Attendance实体类信息
     * @return
     */
    @Override
    public boolean addAttendance(Attendance attendance) {
        return 1 == attendanceMapper.insertAttendance(attendance);
    }

    @Override
    public int getAbsenceByDay() {
        return 0;
    }

    /**
     * 获取某个员工的出勤信息
     * @param staffId 员工号
     * @return 某个员工的所有出勤信息
     */
    @Override
    public List<Attendance> getAttendanceByStaff(String staffId) {
        return attendanceMapper.getAttendanceMonth(staffId);
    }

    /**
     * 获取今天的所有出勤信息
     * @return 今天出勤信息的链表
     */
    @Override
    public List<Attendance> getAttendanceToday() {
        return attendanceMapper.queryAllAttendanceToday();
    }

    /**
     * 判断某人今天是否已经签到
     * @param staffId 员工号
     * @return
     */
    @Override
    public boolean isAttend(String staffId) {
        return null != attendanceMapper.queryAttendanceByStaffToday(staffId);
    }

    /**
     * 获取今天签到迟到的人数
     * @return 迟到人数
     */
    @Override
    public int getLateNum() {
        return attendanceMapper.getLatedStaffNum();
    }

    /**
     * 获取本人本月的出勤数
     * @param staffId 员工号
     * @return
     */
    @Override
    public int getMyAttendance(String staffId) {
        return attendanceMapper.getAttendanceMonth(staffId).size();
    }

    /**
     * 获取本人本月的迟到数
     * @param staffId 员工号
     * @return
     */
    @Override
    public int getMyLateNum(String staffId) {
        return attendanceMapper.getMyLateNum(staffId);
    }


}
