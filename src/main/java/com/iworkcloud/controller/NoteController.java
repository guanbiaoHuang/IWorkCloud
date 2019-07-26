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

@RequestMapping("page")
@Controller
public class NoteController {
    @Autowired
    private INoteService noteService;

    @RequestMapping("/addNote")
    public String addNote(HttpServletRequest request, String content, String title, Model model, HttpSession session) {
        System.out.println(request.getCharacterEncoding());
        Note note = new Note((String) session.getAttribute("staff"), title, new Timestamp(System.currentTimeMillis()), content);
        boolean isAdded = noteService.addNote(note);
        return "redirect:note";
    }

    @RequestMapping("/deleteNote")
    public String deleteNote(String noteId) {
        noteService.deleteNote(noteId);
        return "redirect:note";
    }

    @RequestMapping("/note")
    public String note(Model model, HttpSession session) {

        List<Note> noteList = noteService.getNote((String) session.getAttribute("staff"));
        model.addAttribute("noteList", noteList);
        return "note";

    }

}
