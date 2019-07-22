package com.iworkcloud.service;

import com.iworkcloud.pojo.Activity;

import java.sql.Timestamp;

public interface IActivityService {

    //添加Activity
    boolean addActivity(Activity activity);
    //修改Activity，全部信息
    boolean modifyActivity(Activity activity);
    //获得近期的某类型的活动
    boolean getActivitiesByTime(int recentDays,String tag);


}
