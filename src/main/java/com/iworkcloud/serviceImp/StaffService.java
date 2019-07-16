package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.StaffMapper;
import com.iworkcloud.service.IStaffService;

public class StaffService implements IStaffService {

    private StaffMapper staffMapper;

    public void setStaffMapper(StaffMapper staffMapper) {
        this.staffMapper = staffMapper;
    }

    @Override
    public boolean isBindStaff(String phone) {
       return null!=staffMapper.queryStaffByPhone(phone)?true:false;
    }
}
