package com.iworkcloud.service;

import com.iworkcloud.pojo.Holiday;

import java.util.List;

public interface IHolidayService {
    //添加假期申请
    boolean addHoliday(Holiday holiday);
    //核准假期，即根据id修改假期的ratified值
    boolean ratifyHoliday(String staffId);
    //获取所有假期的ratified状态为waited的假期
    List<Holiday> getHolidayWaitedRatified();
    //获取个人的假期
    List<Holiday> getHolidayWaitedByStaff(String staffId);

}
