package com.iworkcloud.controller;

import com.iworkcloud.pojo.Note;
import com.iworkcloud.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

/**
 * Note控制器
 */
@RequestMapping("page")
@Controller
public class NoteController {
    @Autowired
    private INoteService noteService;

    /**
     * 添加记事
     * @param content 记事内容
     * @param title 记事标题
     * @param model 记事标题
     * @param session 获取session域中的员工号
     * @return
     */
    @RequestMapping("/addNote")
    public String addNote( String content, String title, Model model, HttpSession session) {
        Note note = new Note((String) session.getAttribute("staff"), title, new Timestamp(System.currentTimeMillis()), content);
        boolean isAdded = noteService.addNote(note);
        return "redirect:note";
    }

    /**
     * 删除记事
     * @param noteId 记事Id
     * @return
     */
    @RequestMapping("/deleteNote")
    public String deleteNote(String noteId) {
        noteService.deleteNote(noteId);
        return "redirect:note";
    }

    /**
     * 记事本界面
     * @param model 处理模型数据类
     * @param session 获取session域中的员工号
     * @return
     */
    @RequestMapping("/note")
    public String note(Model model, HttpSession session) {
        //获取所有的记事本
        List<Note> noteList = noteService.getNote((String) session.getAttribute("staff"));
        model.addAttribute("noteList", noteList);
        return "note";

    }

}
