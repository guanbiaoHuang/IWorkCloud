package com.iworkcloud.service;

import java.util.HashMap;

public interface IStaffService {
    boolean isBindStaff(String phone);
    String getStaffID(String phone);
    boolean bindStaff(HashMap<String,Object> map);
    boolean modifyInfo(String staffId);
}
