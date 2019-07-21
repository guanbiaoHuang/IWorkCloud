package com.iworkcloud.service;

import com.iworkcloud.pojo.Activity;

import java.sql.Timestamp;

public interface IActivityService {

    boolean addActivity(Activity activity);
    boolean modifyActivity(Activity activity);
    boolean getActivitiesByTime(int recentDays,String tag);


}
