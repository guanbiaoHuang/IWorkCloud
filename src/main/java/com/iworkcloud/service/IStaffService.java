package com.iworkcloud.service;

import com.iworkcloud.pojo.Staff;

import java.util.HashMap;

public interface IStaffService {
    boolean isBindStaff(String phone);
    String getStaffID(String phone);
    boolean bindStaff(HashMap<String,Object> map);
    boolean modifyInfo(Staff staff);
    Staff getStaffById(String id);
}
