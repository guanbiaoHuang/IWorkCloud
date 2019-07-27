package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.HolidayMapper;
import com.iworkcloud.pojo.Holiday;
import com.iworkcloud.service.IHolidayService;

import java.util.List;

public class HolidayService implements IHolidayService {

    private HolidayMapper holidayMapper;

    public void setHolidayMapper(HolidayMapper holidayMapper) {
        this.holidayMapper = holidayMapper;
    }

    /**
     * 添加假期申请
     * @param holiday
     * @return
     */
    @Override
    public boolean addHoliday(Holiday holiday) {
        return 1 == holidayMapper.insertHoliday(holiday);
    }

    /**
     * 拒绝假期
     * @param id 假期id
     * @return
     */
    @Override
    public boolean refuseHoliday(String id) {
        return 1 == holidayMapper.refuseHoliday(id);
    }

    /**
     * 批准假期
     * @param id 假期id
     * @return
     */
    @Override
    public boolean ratifyHoliday(String id) {
        return 1 == holidayMapper.ratifyHoliday(id);
    }

    /**
     * 获取所有的待批准假期信息
     * @return
     */
    @Override
    public List<Holiday> getHolidayWaitedRatified() {
        return holidayMapper.queryHolidayByRatifyStatus();
    }

    /**
     * 获取本人的假期申请
     * @param staffId 员工号
     * @return
     */
    @Override
    public List<Holiday> getHolidayWaitedByStaff(String staffId) {
        return holidayMapper.queryHolidayByStaffID(staffId);
    }
}
