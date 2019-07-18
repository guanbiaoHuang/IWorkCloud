package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Note;

import java.util.HashMap;
import java.util.List;

public interface NoteMapper {

    int insertNote(Note note);

    int deleteNoteByStuff(String stuffId);

    int updateNoteContent(HashMap<Object,Object>map);

    List<Note> queryNoteByStuff(String stuffId);
}
