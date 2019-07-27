package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.NoteMapper;
import com.iworkcloud.pojo.Note;
import com.iworkcloud.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NoteService implements INoteService {


    private NoteMapper noteMapper;

    public void setNoteMapper(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    /**
     * 添加记事
     * @param note
     * @return
     */
    @Override
    public boolean addNote(Note note) {
        return 1 == noteMapper.insertNote(note);
    }

    /**
     * 获取本人的记事本
     * @param staffId 员工号
     * @return
     */
    @Override
    public List<Note> getNote(String staffId) {
        return noteMapper.queryNoteByStaff(staffId);
    }

    /**
     * 删除记事
     * @param noteId
     * @return
     */
    @Override
    public boolean deleteNote(String noteId) {
        return 1 == noteMapper.deleteNoteById(noteId);
    }
}
