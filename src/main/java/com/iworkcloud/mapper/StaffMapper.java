package com.iworkcloud.mapper;


import com.iworkcloud.pojo.Staff;


public interface StaffMapper {
    Staff queryStaffByPhone(String phone);
}
