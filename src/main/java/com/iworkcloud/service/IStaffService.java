package com.iworkcloud.service;

import com.iworkcloud.pojo.Staff;

import java.util.HashMap;
import java.util.List;

public interface IStaffService {
    List<Staff> getAllStaff();
    boolean isBindStaff(String phone);
    String getStaffID(String phone);
    boolean bindStaff(HashMap<String,Object> map);
    boolean modifyInfo(Staff staff);
    Staff getStaffById(String id);
    boolean addStaff(Staff staff);
}
