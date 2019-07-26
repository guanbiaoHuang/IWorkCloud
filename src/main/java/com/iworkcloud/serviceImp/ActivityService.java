package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.ActivityMapper;
import com.iworkcloud.pojo.Activity;
import com.iworkcloud.service.IActivityService;

import java.util.List;

public class ActivityService implements IActivityService {
    private ActivityMapper activityMapper;

    public void setActivityMapper(ActivityMapper activityMapper) {
        this.activityMapper = activityMapper;
    }

    @Override
    public boolean addActivity(Activity activity) {
        return 1 == activityMapper.insertActivity(activity);
    }

    @Override
    public boolean modifyActivity(Activity activity) {
        return false;
    }

    @Override
    public List<Activity> getActivitiesByTime(int recentDays, String tag) {
        return activityMapper.queryActivitiesByDateAndTag(recentDays, tag);
    }

    @Override
    public List<Activity> getActivityByTag(String tag) {
        return activityMapper.queryActivityByTag(tag);
    }

    @Override
    public boolean deleteActivityById(long id) {
        return 1 == activityMapper.deleteActivityById(id);
    }
}
