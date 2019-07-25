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
@RequestMapping("page")
@Controller
public class StaffController {
    @Autowired
    private IStaffService staffService;
    @Autowired
    private IUserService userService;

    @RequestMapping("/updatePassword")
    public String modifyPassword(Model model,String oldPassword, String newPassword, HttpSession session){

        String phone = staffService.getPhoneByStaffId(session.getAttribute("staff").toString());
        if(userService.login(phone,oldPassword)){
            boolean isSuccess = userService.updatePassword(phone,newPassword);
            return "redirect:index";
        }
        return "redirect:index";
    }


    @RequestMapping("/invalidateSession")
    public String invalidateSession(HttpSession session){
        session.removeAttribute("staff");
        return "redirect:login";
    }

    @RequestMapping("/staffModify")
    public String staffModify(Model model,String id){
        model.addAttribute("id",id);

        return "staffAdd";
    }

    @RequestMapping("/staffManage")
    public String staffManage(Model model){
        List<Staff> staffList= staffService.getAllStaff();
        model.addAttribute("staffList",staffList);
        for (Staff staff:staffList){
            System.out.println(staff.getName()+"------------"+staff.getId());
        }
        return "staffManage";
    }

    @RequestMapping("/deleteStaff")
    public String deleteStaff(String id){
        staffService.deleteStaff(id);
        return "redirect:staffManage";
    }


    @RequestMapping("/addStaff")
    public String addStaff(String id,String name,String team,String department,String phone,String sex){
        Staff staff = new Staff(id,name,team,department,phone,sex);

        staffService.addStaff(staff);

        return "redirect:staffManage";
    }

    @RequestMapping("/addStaffXls")
    public String addStaffXls(@RequestParam("file") MultipartFile file){
        staffService.addStaffByExcel(file);
        return "redirect:staffManage";
    }
}
