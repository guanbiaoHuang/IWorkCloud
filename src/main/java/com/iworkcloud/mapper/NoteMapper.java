package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Note;

import java.util.HashMap;
import java.util.List;

public interface NoteMapper {

    int insertNote(Note note);

    int deleteNoteByStaff(String staffId);

    int deleteNoteById(String noteId);

    List<Note> queryNoteByStaff(String staffId);
}
