package com.iworkcloud.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iworkcloud.pojo.User;
import com.iworkcloud.service.IUserService;
import com.iworkcloud.utils.GetMessageCode;
import com.iworkcloud.utils.UploadUtils;



@Controller
public class UserController {
	@Autowired
	private IUserService userService;
	
	
	@ResponseBody
	@RequestMapping("getIcon")
	public String getIcon(@RequestParam("phone")String phone) {
		return userService.getIcon(phone);
	}
	
	@RequestMapping("register")
	public String toReigister() {	
		return "register";
	}
	
	@RequestMapping("login")
	public String toLogin() {
		return "login";
	}
	
	@ResponseBody
	@RequestMapping("checkCode")
	public String getCode(@RequestParam("phone")String phone,HttpSession session,HttpServletResponse response){
		String firstPhone = phone;
		String code = GetMessageCode.getCode(firstPhone);
		if(code.length()>0) {
			session.setAttribute(firstPhone, code);
		}
		return code.length()>0?"获取验证码成功，注意查收":"获取验证码失败，请重试";
	}
	
	@RequestMapping("log")
	public ModelAndView login(HttpServletRequest request,HttpSession session) {
		ModelAndView mv = new ModelAndView("login");
		boolean isloged = userService.login(request.getParameter("phone"),
				request.getParameter("password"));
		if(isloged) {
			session.setAttribute("userPhone", request.getAttribute("phone"));
		}else {
			mv.addObject("msg","登陆失败");
		}
		return mv;
	}
	
	@RequestMapping("reg")
	public ModelAndView register(HttpServletRequest request,HttpSession session,@RequestParam("icon")MultipartFile file) {
		ModelAndView mv = new ModelAndView("register");
		
		if(session.getAttribute(request.getParameter("phone"))==null||!session.getAttribute(request.getParameter("phone")).equals(request.getParameter("verifyCode"))) {
			mv.addObject("msg", "验证码与手机号不一致");
			return mv;
		}
		User user = new User(request.getParameter("phone"),
				request.getParameter("password"),
				request.getContextPath()+"/img/faces/"+request.getParameter("phone")+file.getOriginalFilename());;
		if(!userService.isExist(request.getParameter("phone"))) {
			String path = request.getServletContext().getRealPath("/")+"img/faces/"+request.getParameter("phone")+file.getOriginalFilename();
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
					session.removeAttribute(request.getParameter("phone"));
				} 									
			}else {
				mv.addObject("msg","注册失败");
			}
			
		}else {
			mv.addObject("msg","注册失败，手机号已存在");
		}
		return mv;
	}
}
