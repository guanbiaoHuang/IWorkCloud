package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Note;

import java.util.HashMap;
import java.util.List;

public interface NoteMapper {

    void insertNote(Note note);

    void deleteNoteByStuff(String stuffId);

    void updateNoteContent(HashMap<Object,Object>map);

    List<Note> queryNoteByStuff(String stuffId);
}
