package com.iworkcloud.service;

import com.iworkcloud.pojo.Out;

import java.util.List;

public interface IOutService {

    boolean addOut(Out out);

    //获取今天的出差状况
    List<Out> outToday();

    boolean deleteOut(String id);

}
