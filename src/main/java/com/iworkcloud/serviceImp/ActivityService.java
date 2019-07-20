package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.ActivityMapper;
import com.iworkcloud.service.IActivityService;

public class ActivityService implements IActivityService {
    private ActivityMapper activityMapper;

    public void setActivityMapper(ActivityMapper activityMapper) {
        this.activityMapper = activityMapper;
    }
}
