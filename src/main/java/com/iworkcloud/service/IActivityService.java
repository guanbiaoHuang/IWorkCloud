package com.iworkcloud.service;

import com.iworkcloud.pojo.Activity;

import java.sql.Timestamp;
import java.util.List;

public interface IActivityService {

    //添加Activity
    boolean addActivity(Activity activity);

    //修改Activity，全部信息
    boolean modifyActivity(Activity activity);

    //获得指定近几天的某类型的活动
    List<Activity> getActivitiesByTime(int recentDays, String tag);

    //获取某种类型的活动
    List<Activity> getActivityByTag(String tag);

    //删除活动
    boolean deleteActivityById(long id);
}
