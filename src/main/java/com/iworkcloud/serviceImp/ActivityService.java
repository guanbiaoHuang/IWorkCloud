package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.ActivityMapper;
import com.iworkcloud.pojo.Activity;
import com.iworkcloud.service.IActivityService;

import java.util.List;

public class ActivityService implements IActivityService {
    private ActivityMapper activityMapper;
    //set方式进行IOC注入
    public void setActivityMapper(ActivityMapper activityMapper) {
        this.activityMapper = activityMapper;
    }

    /**
     * 添加活动
     * @param activity activity实体类对象
     * @return
     */
    @Override
    public boolean addActivity(Activity activity) {
        return 1 == activityMapper.insertActivity(activity);
    }

    /**
     * 修改Activity
     * @param activity activity实体类对象
     * @return
     */
    @Override
    public boolean modifyActivity(Activity activity) {
        return false;
    }

    /**
     * 获取指定近几天的某种类型的活动信息
     * @param recentDays 指定的天数
     * @param tag 活动类型
     * @return
     */
    @Override
    public List<Activity> getActivitiesByTime(int recentDays, String tag) {
        return activityMapper.queryActivitiesByDateAndTag(recentDays, tag);
    }

    /**
     * 获取某种类型的活动
     * @param tag 活动类型
     * @return
     */
    @Override
    public List<Activity> getActivityByTag(String tag) {
        return activityMapper.queryActivityByTag(tag);
    }

    /**
     * 删除活动
     * @param id 活动Id
     * @return
     */
    @Override
    public boolean deleteActivityById(long id) {
        return 1 == activityMapper.deleteActivityById(id);
    }
}
