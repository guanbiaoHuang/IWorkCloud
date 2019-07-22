package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Activity;
import com.iworkcloud.utils.TimeTrans;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface ActivityMapper {


    List<Activity> queryActivitiesByDateAndTag(@Param("days") int days, @Param("tag")String tag);


    int updateActivityById(HashMap<Object,Object>map);


    int insertActivity(Activity activity);


}
