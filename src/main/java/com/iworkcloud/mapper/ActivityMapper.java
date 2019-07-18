package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Activity;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface ActivityMapper {

    List<Activity> queryActivityById(int id);
    List<Activity> queryActivitiesByDate(Date date);
    List<Activity> queryActivitiesByTag(String tag);

    int updateActivityById(HashMap<Object,Object>map);

    int deleteActivityById(int id);

    int insertActivity(Activity activity);


}
