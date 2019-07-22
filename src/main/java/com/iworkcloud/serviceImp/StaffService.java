package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.StaffMapper;
import com.iworkcloud.pojo.Staff;
import com.iworkcloud.service.IStaffService;

import java.util.HashMap;

public class StaffService implements IStaffService {

    private StaffMapper staffMapper;

    public void setStaffMapper(StaffMapper staffMapper) {
        this.staffMapper = staffMapper;
    }

    @Override
    public boolean isBindStaff(String phone) {
       return null!=staffMapper.queryStaffByPhone(phone)?true:false;
    }

    @Override
    public String getStaffID(String phone) {
        return staffMapper.queryStaffByPhone(phone);
    }

    @Override
    public boolean bindStaff(HashMap<String, Object> map) {
        int status = staffMapper.updatePhoneById(map);
        return status==1?true:false;
    }

    @Override
    public boolean modifyInfo(Staff staff) {
        return false;
    }


}
