package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Out;

import java.util.HashMap;
import java.util.List;

public interface OutMapper {

    int insertOut(Out out);

    List<Out>queryOutByStaffId(String staffId);

    int deleteOut(String staffId);

    int updateOutContent(HashMap<Object,Object>map);
}
