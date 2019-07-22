package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.ActivityMapper;
import com.iworkcloud.pojo.Activity;
import com.iworkcloud.service.IActivityService;

public class ActivityService implements IActivityService {
    private ActivityMapper activityMapper;

    public void setActivityMapper(ActivityMapper activityMapper) {
        this.activityMapper = activityMapper;
    }

    @Override
    public boolean addActivity(Activity activity) {
        return 1==activityMapper.insertActivity(activity)?true:false;
    }

    @Override
    public boolean modifyActivity(Activity activity) {
        return false;
    }

    @Override
    public boolean getActivitiesByTime(int recentDays, String tag) {
        return false;
    }
}
