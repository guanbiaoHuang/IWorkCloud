package com.iworkcloud.controller;

import com.iworkcloud.pojo.Staff;
import com.iworkcloud.service.IStaffService;
import com.iworkcloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Staff控制器
 */
@RequestMapping("page")
@Controller
public class StaffController {
    @Autowired
    private IStaffService staffService;
    @Autowired
    private IUserService userService;

    /**
     * 修改密码
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @param session 获取session域中的员工号
     * @return
     */
    @RequestMapping("/updatePassword")
    public String modifyPassword(String oldPassword, String newPassword, HttpSession session) {
        //在修改密码前先判断旧密码是否正确
        String phone = staffService.getPhoneByStaffId(session.getAttribute("staff").toString());
        if (userService.login(phone, oldPassword)) {
            boolean isSuccess = userService.updatePassword(phone, newPassword);
            return "redirect:index";
        }
        return "redirect:index";
    }

    /**
     * 登出
     * 清除session域中值
     * @param session 清除session域中的值
     * @return
     */
    @RequestMapping("/invalidateSession")
    public String invalidateSession(HttpSession session) {
        //清除session域中的值
        session.removeAttribute("staff");
        session.removeAttribute("department");
        return "redirect:login";
    }

    @RequestMapping("/staffModify")
    public String staffModify(Model model, String id) {
        //将传入的员工ID值传至修改员工信息的Iframe中
        model.addAttribute("id", id);
        return "staffAdd";
    }

    /**
     * 员工管理界面
     * @param model 处理模型数据类
     * @return
     */

    @RequestMapping("/staffManage")
    public String staffManage(Model model) {
        List<Staff> staffList = staffService.getAllStaff();
        model.addAttribute("staffList", staffList);
        return "staffManage";
    }

    /**
     * 删除员工
     * @param id 员工号
     * @return
     */
    @RequestMapping("/deleteStaff")
    public String deleteStaff(String id) {
        staffService.deleteStaff(id);
        return "redirect:staffManage";
    }

    /**
     * 添加员工信息
     * @param id 员工号
     * @param name 姓名
     * @param team 团队
     * @param department 部门
     * @param phone 手机号
     * @param sex 性别
     * @return
     */
    @RequestMapping("/addStaff")
    public String addStaff(String id, String name, String team, String department, String phone, String sex) {
        Staff staff = new Staff(id, name, team, department, phone, sex);

        staffService.addStaff(staff);

        return "redirect:staffManage";
    }

    /**
     * 通过Excel表格批量添加员工信息
     * @param file 上传的Excel表格文件
     * @return
     */
    @RequestMapping("/addStaffXls")
    public String addStaffXls(@RequestParam("file") MultipartFile file) {
        staffService.addStaffByExcel(file);
        return "redirect:staffManage";
    }
}
