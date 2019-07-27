package com.iworkcloud.controller;

import com.iworkcloud.pojo.Idea;
import com.iworkcloud.serviceImp.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

/**
 * Idea控制器
 */
@RequestMapping("page")
@Controller
public class IdeaController {

    @Autowired
    private IdeaService ideaService;

    /**
     * 添加想法至意见墙
     * @param title 标题
     * @param content 内容
     * @param session 获取session中的员工号
     * @return
     */
    @RequestMapping("/addIdea")
    public String addIdea(String title, String content, HttpSession session) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Idea idea = new Idea(session.getAttribute("staff").toString(), title, timestamp, content);

        ideaService.addIdea(idea);
        return "redirect:index";
    }
}
