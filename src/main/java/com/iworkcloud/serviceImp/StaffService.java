package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.StaffMapper;
import com.iworkcloud.pojo.Staff;
import com.iworkcloud.service.IStaffService;
import com.iworkcloud.utils.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class StaffService implements IStaffService {

    private StaffMapper staffMapper;

    public void setStaffMapper(StaffMapper staffMapper) {
        this.staffMapper = staffMapper;
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffMapper.queryAllStaff();
    }

    @Override
    public boolean isBindStaff(String phone) {
       return null!=staffMapper.queryStaffByPhone(phone)?true:false;
    }

    @Override
    public String getStaffID(String phone) {
        return staffMapper.queryStaffByPhone(phone).getId();
    }

    @Override
    public boolean bindStaff(HashMap<String, Object> map) {
        int status = staffMapper.updatePhoneById(map);
        return status==1?true:false;
    }

    @Override
    public boolean modifyInfo(Staff staff) {
        return 1==staffMapper.updateAllById(staff)?true:false;
    }

    @Override
    public Staff getStaffById(String id) {
        return staffMapper.queryStaffById(id);
    }

    @Override
    public boolean addStaff(Staff staff) {
        return 1==staffMapper.insertStaff(staff)?true:false;
    }

    @Override
    public boolean addStaffByExcel(MultipartFile file) {
        InputStream inputStream = null;
        List<List<Object>> lists = null;
        try {
            inputStream = file.getInputStream();
            lists = new ExcelUtil().getBankListByExcel(inputStream,file.getOriginalFilename());
            for (int i = 0; i<lists.size();i++){
                List<Object> list = lists.get(i);
                Staff staff = new Staff(String.valueOf(list.get(0)),
                        String.valueOf(list.get(1)),
                        String.valueOf(list.get(2)),
                        String.valueOf(list.get(3)),
                        String.valueOf(list.get(4)),
                        String.valueOf(list.get(5)));
                System.out.println(staff);
                staffMapper.insertStaff(staff);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (inputStream!=null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    @Override
    public boolean deleteStaff(String id) {
        return 1==staffMapper.deleteStaff(id)?true:false;
    }

    @Override
    public String getPhoneByStaffId(String id) {
        return staffMapper.queryPhoneById(id);
    }

    @Override
    public int getStaffCount() {
        return staffMapper.queryStaffNum();
    }

}
