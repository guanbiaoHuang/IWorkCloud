package com.iworkcloud.service;

import com.iworkcloud.pojo.Schedule;

import java.util.List;

public interface IScheduleService {
    boolean addSchedule(Schedule schedule);
    boolean emptyPastSchedule(String staffId);
    boolean modifySchedule(Schedule schedule);
    List<Schedule> getRecentSchedule(int recentDays, String staffId);
}
