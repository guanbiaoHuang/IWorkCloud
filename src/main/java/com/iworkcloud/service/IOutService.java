package com.iworkcloud.service;

import com.iworkcloud.pojo.Out;

import java.util.List;

public interface IOutService {
    boolean addOut(Out out);
    List<Out> outToday();

}
