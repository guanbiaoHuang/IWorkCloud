package com.iworkcloud.mapper;


import com.iworkcloud.pojo.Staff;

import java.util.HashMap;


public interface StaffMapper {
    int insertStaff(Staff staff);
    String queryStaffByPhone(String phone);
    int updatePhoneById(HashMap<String,Object> map);

}
