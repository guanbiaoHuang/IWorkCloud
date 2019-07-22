package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Out;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

public interface OutMapper {

    int insertOut(Out out);

    List<Out> queryOutByTime(Timestamp time);

    int deleteOut(String staffId);

    int updateOutContent(HashMap<Object,Object>map);
}
