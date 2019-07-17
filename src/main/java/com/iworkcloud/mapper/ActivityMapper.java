package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Activity;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface ActivityMapper {

    Activity queryActivityById(int id);
    List<Activity> queryActivitiesByDate(Date date);
    List<Activity> queryActivitiesByTag(String tag);

    void updateActivityById(HashMap<Object,Object>map);

    void deleteActivityById(int id);

    void insertActivity(Activity activity);


}
