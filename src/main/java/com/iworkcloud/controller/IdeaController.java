package com.iworkcloud.controller;

import com.iworkcloud.pojo.Idea;
import com.iworkcloud.serviceImp.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

@RequestMapping("page")
@Controller
public class IdeaController {

    @Autowired
    private IdeaService ideaService;


    @RequestMapping("/addIdea")
    public String addIdea(String title, String content, HttpSession session){

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Idea idea = new Idea(session.getAttribute("staff").toString(),title,timestamp,content);

        ideaService.addIdea(idea);
        return "redirect:index";
    }
}
