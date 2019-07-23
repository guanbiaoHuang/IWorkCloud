package com.iworkcloud.mapper;


import com.iworkcloud.pojo.Staff;

import java.util.HashMap;
import java.util.List;


public interface StaffMapper {
    int insertStaff(Staff staff);
    Staff queryStaffByPhone(String phone);
    int updatePhoneById(HashMap<String,Object> map);
    int updateAllById(Staff staff);
    Staff queryStaffById(String id);
    List<Staff> queryAllStaff();
    String queryPhoneById(String id);
    int deleteStaff(String id);

}
