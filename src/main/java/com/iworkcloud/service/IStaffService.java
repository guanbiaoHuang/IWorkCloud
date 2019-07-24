package com.iworkcloud.service;

import com.iworkcloud.pojo.Staff;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
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
    boolean addStaffByExcel(MultipartFile file);
    boolean deleteStaff(String id);
    String getPhoneByStaffId(String id);
    int getStaffCount();
    String getStaffDepartment(String staffId);
}
