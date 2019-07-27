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

    /**
     * 获取所有的员工
     * @return
     */
    @Override
    public List<Staff> getAllStaff() {
        return staffMapper.queryAllStaff();
    }

    /**
     * 判断手机号是否与员工绑定
     * @param phone 手机号
     * @return
     */
    @Override
    public boolean isBindStaff(String phone) {
        return null != staffMapper.queryStaffByPhone(phone);
    }

    /**
     * 根据手机获取员工号
     * @param phone
     * @return
     */
    @Override
    public String getStaffID(String phone) {
        return staffMapper.queryStaffByPhone(phone).getId();
    }

    /**
     * 绑定员工手机号
     * @param map 手机号原员工号
     * @return
     */
    @Override
    public boolean bindStaff(HashMap<String, Object> map) {
        int status = staffMapper.updatePhoneById(map);
        return status == 1;
    }

    /**
     * 修改员工信息
     * @param staff 员工号
     * @return
     */
    @Override
    public boolean modifyInfo(Staff staff) {
        return 1 == staffMapper.updateAllById(staff);
    }

    /**
     * 根据员工工号获取员工信息
     * @param id
     * @return
     */
    @Override
    public Staff getStaffById(String id) {
        return staffMapper.queryStaffById(id);
    }

    /**
     * 添加员工
     * @param staff
     * @return
     */
    @Override
    public boolean addStaff(Staff staff) {
        return 1 == staffMapper.insertStaff(staff);
    }

    /**
     * 使用Apache Poi组件从Excel文件中批量添加信息
     * @param file 上传的文件
     * @return
     */
    @Override
    public boolean addStaffByExcel(MultipartFile file) {
        InputStream inputStream = null;
        List<List<Object>> lists = null;
        try {
            //获取文件的输入流
            inputStream = file.getInputStream();
            //使用ExcelUtil从输入流获取信息到链表中
            lists = new ExcelUtil().getBankListByExcel(inputStream, file.getOriginalFilename());
            for (int i = 0; i < lists.size(); i++) {
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
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @Override
    public boolean deleteStaff(String id) {
        return 1 == staffMapper.deleteStaff(id);
    }

    /**
     * 获取员工手机号
     * @param id 员工工号
     * @return
     */
    @Override
    public String getPhoneByStaffId(String id) {
        return staffMapper.queryPhoneById(id);
    }

    /**
     * 获取员工人数
     * @return
     */
    @Override
    public int getStaffCount() {
        return staffMapper.queryStaffNum();
    }

    /**
     * 获取员工的部门
     * @param staffId
     * @return
     */
    @Override
    public String getStaffDepartment(String staffId) {
        return staffMapper.queryDepartmentById(staffId);
    }

}
