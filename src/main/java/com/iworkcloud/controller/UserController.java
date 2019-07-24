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


@RequestMapping("user")
@Controller
public class UserController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IStaffService staffService;

	@ResponseBody
	@RequestMapping("/getIcon")
	public String getIcon(@RequestParam("phone")String phone,HttpServletRequest request) {
		return userService.getIcon(phone);
	}

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

	@RequestMapping("/register")
	public String toReigister() {
		return "register";
	}

	@RequestMapping("/login")
	public String toLogin() {
		return "login";
	}

	@ResponseBody
	@RequestMapping("/getImg")
	public byte[] getImg(@RequestParam("img") String name, HttpServletRequest request) throws IOException {
		String fileLocation = request.getServletContext().getRealPath("WEB-INF/img/faces/");
		String path = fileLocation + name;
		InputStream is = new FileInputStream(path);
		byte[] flush = new byte[is.available()];
		is.read(flush);
		return flush;
	}

	@ResponseBody
	@RequestMapping("/checkCode")
	public String getCode(@RequestParam("phone")String phone,HttpSession session,HttpServletResponse response){
		if(userService.isExist(phone))
			return "该手机号已注册";
		String code = GetMessageCode.getCode(phone);
		if(code.length()>0)
			session.setAttribute(phone, code);
		return code.length()>0?"获取验证码成功，注意查收":"获取验证码失败，请重试";
	}

	@RequestMapping("/updatePassword")
	public String modifyPassword(Model model,String oldPassword, String newPassword, HttpSession session){
		if(session.getAttribute("staff")!=null){
			String phone = staffService.getPhoneByStaffId(session.getAttribute("staff").toString());
			if(userService.login(phone,oldPassword)){
				boolean isSuccess = userService.updatePassword(phone,newPassword);
				return "redirect:login";
			}else {
				return "redirect:index";
			}
		}
		model.addAttribute("msg","会话，请重新登陆");
		return "forward:login";

	}

	@RequestMapping("/log")
	public ModelAndView login(String phone, String password,HttpServletRequest request,HttpSession session) {
		ModelAndView mv = new ModelAndView("login");
		boolean isloged = userService.login(phone, password);
		if(isloged) {
			if(staffService.isBindStaff(phone)){
				mv.addObject("msg","success");
				session.setAttribute("staff",staffService.getStaffID(phone));
				return mv;
			}else{
				mv.addObject("msg","notBind");
				session.setAttribute("phone",phone);
				return mv;
			}

		}else {
			mv.addObject("msg","登陆失败");
		}
		return mv;
	}
	
	@RequestMapping("/reg")
	public ModelAndView register(String phone, String password, String verifyCode, HttpServletRequest request, HttpSession session, @RequestParam("icon")MultipartFile file) {
		ModelAndView mv = new ModelAndView("register");
		/*
		if(session.getAttribute(phone)==null||!session.getAttribute(phone).equals(verifyCode)) {
			mv.addObject("msg", "验证码与手机号不一致");
			return mv;
		}
		*/
		User user = new User(phone,password, phone+file.getOriginalFilename());;
		if(!userService.isExist(phone)) {
			String path = request.getServletContext().getRealPath("WEB-INF/img/faces/")+phone+file.getOriginalFilename();
			try {
				UploadUtils.uploadIcon(path, request, file.getInputStream());						
			} catch (IOException e) {
				e.printStackTrace();
				user = null;
			}
			if(null!=user) {
				int status =userService.register(user);
				if(status == 1) {
					mv.setViewName("login");
					mv.addObject("msg","注册成功");
					session.removeAttribute(phone);
				}
			}else {
				mv.addObject("msg","注册失败");
			}
			
		}else {
			mv.addObject("msg","注册失败，手机号已存在");
		}
		return mv;
	}


	@RequestMapping("/findPassword")
    public String newPassword(String newPhone,String password){
	    userService.updatePassword(newPhone,password);
	    return "redirect:user/login";
    }

}
