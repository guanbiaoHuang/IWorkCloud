package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Out;

import java.util.HashMap;
import java.util.List;

public interface OutMapper {

    int insertOut(Out out);

    List<Out>queryOutByStuffId(String stuffId);

    int deleteOut(String stuffId);

    int updateOutContent(HashMap<Object,Object>map);
}
