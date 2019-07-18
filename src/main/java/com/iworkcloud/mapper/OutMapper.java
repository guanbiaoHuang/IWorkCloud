package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Out;

import java.util.HashMap;
import java.util.List;

public interface OutMapper {

    void insertOut(Out out);

    List<Out>queryOutByStuffId(String stuffId);

    void deleteOut(String stuffId);

    void updateOutContent(HashMap<Object,Object>map);
}
