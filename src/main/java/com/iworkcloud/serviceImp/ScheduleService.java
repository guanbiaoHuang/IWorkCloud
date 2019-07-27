package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.ScheduleMapper;
import com.iworkcloud.pojo.Schedule;
import com.iworkcloud.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.*;

public class ScheduleService implements IScheduleService {

    private ScheduleMapper scheduleMapper;

    public void setScheduleMapper(ScheduleMapper scheduleMapper) {
        this.scheduleMapper = scheduleMapper;
    }

    /**
     * 添加日程
     * @param schedule
     * @return
     */
    @Override
    public boolean addSchedule(Schedule schedule) {
        return 1 == scheduleMapper.insertSchedule(schedule);
    }

    /**
     * 清空过去的日程
     * @param staffId
     * @return
     */
    @Override
    public boolean emptyPastSchedule(String staffId) {
        return 1 == scheduleMapper.deleteScheduleByStaffId(staffId);
    }

    /**
     * 修改日程
     * @param schedule
     * @return
     */
    @Override
    public boolean modifySchedule(Schedule schedule) {
        return 1 == scheduleMapper.updateScheduleContent(schedule);
    }

    /**
     * 获取最近几天的日程
     * @param recentDays 天数
     * @param staffId 员工号
     * @return
     */
    @Override
    public List<Schedule> getRecentSchedule(int recentDays, String staffId) {
        return scheduleMapper.queryScheduleByDays(recentDays, staffId);
    }

    /**
     * 删除日程
     * @param id
     * @return
     */
    @Override
    public boolean deleteSchedule(String id) {
        return 1 == scheduleMapper.deleteSchedule(id);
    }
}
