package com.iworkcloud.service;

import com.iworkcloud.pojo.Schedule;

import java.util.List;

public interface IScheduleService {

    boolean addSchedule(Schedule schedule);
    //删除从前的日程，时间比较（根据员工id）
    boolean emptyPastSchedule(String staffId);
    //修改日程
    boolean modifySchedule(Schedule schedule);
    List<Schedule> getRecentSchedule(int recentDays, String staffId);
}
