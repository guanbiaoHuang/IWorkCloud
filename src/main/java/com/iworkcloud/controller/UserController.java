package com.iworkcloud.controller;

import java.io.*;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iworkcloud.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iworkcloud.pojo.User;
import com.iworkcloud.service.IUserService;
import com.iworkcloud.utils.GetMessageCode;
import com.iworkcloud.utils.UploadUtils;

/**
 * User控制器
 */
@RequestMapping("user")
@Controller
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IStaffService staffService;

    /**
     * Ajax异步获取头像的文件名
     * @param phone 手机号
     * @return
     */
    @ResponseBody
    @RequestMapping("/getIcon")
    public String getIcon(@RequestParam("phone") String phone) {
        return userService.getIcon(phone);
    }

    /**
     * Ajax异步进行员工查询以及手机号绑定
     * @param session 获取session域中的手机号
     * @param staffID 输入的员工号
     * @return
     */
    @ResponseBody
    @RequestMapping("/bindStaff")
    public String bindStaff(HttpSession session, @RequestParam("staffID") String staffID) {
        //判断是否登陆
        if (session.getAttribute("phone") != null) {
            //绑定员工号的手机号
            HashMap<String, Object> map = new HashMap<>();
            map.put("phone", session.getAttribute("phone"));
            map.put("id", staffID);
            if (staffService.bindStaff(map)) {
                session.removeAttribute("phone");
                session.setAttribute("staff", staffID);
                return "success";
            } else {
                session.removeAttribute("phone");
                return "绑定失败，重新登陆后绑定";
            }
        } else {
            return "未登陆";
        }

    }

    /**
     * 页面跳转至注册界面
     * @return
     */
    @RequestMapping("/register")
    public String toReigister() {
        return "register";
    }

    /**
     * 页面跳转至登陆界面
     * @return
     */
    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    /**
     * Ajax获取头像
     * @param name 头像文件名
     * @param request Request域
     * @return 头像文件的字节数组
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/getImg")
    public byte[] getImg(@RequestParam("img") String name, HttpServletRequest request) throws IOException {
        //获取头像文件存储的地址，并添加文件名获得头像地址
        String fileLocation = request.getServletContext().getRealPath("WEB-INF/img/faces/");
        String path = fileLocation + name;
        InputStream is = new FileInputStream(path);
        //读取到byte数组中
        byte[] flush = new byte[is.available()];
        is.read(flush);
        return flush;
    }

    /**
     * Ajax异步获取手机验证码
     * @param phone 手机号
     * @param session 存储信息至session域
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkCode")
    public String getCode(@RequestParam("phone") String phone, HttpSession session, HttpServletResponse response) {
        //先判断是否已注册
        if (userService.isExist(phone))
            return "该手机号已注册";
        //获取验证码，并判断是否获取成功
        String code = GetMessageCode.getCode(phone);
        if (code.length() > 0)
            session.setAttribute(phone, code);
        return code.length() > 0 ? "获取验证码成功，注意查收" : "获取验证码失败，请重试";
    }

    /**
     * 登陆
     * @param phone 手机号
     * @param password 密码
     * @param request request域
     * @param session 存储信息至session域中
     * @return
     */
    @RequestMapping("/log")
    public ModelAndView login(String phone, String password, HttpServletRequest request, HttpSession session) {
        ModelAndView mv = new ModelAndView("login");
        boolean isloged = userService.login(phone, password);
        //判断是否登陆
        if (isloged) {
            //判断手机号是否绑定员工号
            if (staffService.isBindStaff(phone)) {
                mv.addObject("msg", "success");
                String staffId = staffService.getStaffID(phone);
                //在session域中添加员工信息
                session.setAttribute("staff", staffId);
                session.setAttribute("department", staffService.getStaffDepartment(staffId));
                return mv;
            } else {
                mv.addObject("msg", "notBind");
                session.setAttribute("phone", phone);
                return mv;
            }

        } else {
            mv.addObject("msg", "登陆失败");
        }
        return mv;
    }

    /**
     * 初测
     * @param phone 手机号
     * @param password 密码
     * @param verifyCode 手机验证码
     * @param request request域
     * @param session 从session域中获取验证码
     * @param file 上传的头像文件
     * @return
     */
    @RequestMapping("/reg")
    public ModelAndView register(String phone, String password, String verifyCode, HttpServletRequest request, HttpSession session, @RequestParam("icon") MultipartFile file) {
        ModelAndView mv = new ModelAndView("register");
        //判断session域中是否有验证码以及验证码的正确性
		if(session.getAttribute(phone)==null||!session.getAttribute(phone).equals(verifyCode)) {
			mv.addObject("msg", "验证码与手机号不一致");
			return mv;
		}
        User user = new User(phone, password, phone + file.getOriginalFilename());
		//判断手机号是否已注册
        if (!userService.isExist(phone)) {
            //指定上传路径
            String path = request.getServletContext().getRealPath("WEB-INF/img/faces/") + phone + file.getOriginalFilename();
            try {
                //调用工具栏进行文件上传
                UploadUtils.uploadIcon(path, request, file.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
                //发生异常将user置空
                user = null;
            }
            if (null != user) {
                int status = userService.register(user);
                //判断是否注册成功
                if (status == 1) {
                    mv.setViewName("login");
                    mv.addObject("msg", "注册成功");
                    session.removeAttribute(phone);
                }
            } else {
                mv.addObject("msg", "注册失败");
            }

        } else {
            mv.addObject("msg", "注册失败，手机号已存在");
        }
        return mv;
    }

    /**
     * 找回密码
     * @param newPhone 手机号
     * @param password 密码
     * @return
     */
    @RequestMapping("/modifyPassword")
    public String newPassword(String newPhone, String password) {
        userService.updatePassword(newPhone, password);
        return "redirect:login";
    }

    /**
     * 跳转至找回密码界面
     * @return
     */
    @RequestMapping("/findPassword")
    public String findPassword() {
        return "findPassword";
    }

}
