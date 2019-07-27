package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Activity;
import com.iworkcloud.utils.TimeTrans;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface ActivityMapper {

    //获取近几天的某种类型的Activity如活动、福利、会议
    List<Activity> queryActivitiesByDateAndTag(@Param("days") int days, @Param("tag") String tag);

    int updateActivityById(HashMap<Object, Object> map);

    List<Activity> queryActivityByTag(String tag);

    int insertActivity(Activity activity);

    int deleteActivityById(long id);
}
