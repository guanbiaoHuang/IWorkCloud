package com.iworkcloud.controller;

import com.iworkcloud.pojo.Staff;
import com.iworkcloud.service.IStaffService;
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



    @RequestMapping("/invalidateSession")
    public String invalidateSession(HttpSession session){
        session.removeAttribute("staff");
        return "redirect:page/index";
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
        return "redirect:page/staffManage";
    }


    @RequestMapping("/addStaff")
    public String addStaff(String id,String name,String team,String department,String phone,String sex){
        Staff staff = new Staff(id,name,team,department,phone,sex);

        staffService.addStaff(staff);

        return "redirect:page/staffManage";
    }

    @RequestMapping("/SaddStaffXls")
    public String addStaffXls(@RequestParam("file") MultipartFile file){
        staffService.addStaffByExcel(file);
        return "redirect:page/staffManage";
    }
}
