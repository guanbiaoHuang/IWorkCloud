package com.iworkcloud.service;

import com.iworkcloud.pojo.Note;

import java.util.List;

public interface INoteService {
    boolean addNote(Note note);
    List<Note> getNote(String staffId);
    boolean deleteNote(String noteId);
}
