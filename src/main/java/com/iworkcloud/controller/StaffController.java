package com.iworkcloud.controller;

import com.iworkcloud.pojo.Staff;
import com.iworkcloud.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class StaffController {
    @Autowired
    private IStaffService staffService;

    @ResponseBody
    @RequestMapping("bindStaff")
    public String bindStaff(HttpSession session, @RequestParam("staffID") String staffID){
        if(session.getAttribute("phone")!=null){
            HashMap<String,Object> map= new HashMap<>();
            map.put("phone",session.getAttribute("phone"));
            map.put("id",staffID);
            if(staffService.bindStaff(map)) {
                session.removeAttribute("phone");
                session.setAttribute("staff", staffID);
                return "success";
            }else{
                session.removeAttribute("phone");
                return "绑定失败，重新登陆后绑定";
            }
        }else{
            return "未登陆";
        }

    }

    @RequestMapping("invalidateSession")
    public String invalidateSession(HttpSession session){
        session.removeAttribute("staff");
        return "redirect:index";
    }

    @RequestMapping("staffManage")
    public String staffManage(Model model){
        List<Staff> staffList= staffService.getAllStaff();
        model.addAttribute("staffList",staffList);
        for (Staff staff:staffList){
            System.out.println(staff.getName()+"------------"+staff.getId());
        }
        return "staffManage";
    }
}
