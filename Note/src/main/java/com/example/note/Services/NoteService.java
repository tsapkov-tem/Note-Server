package com.example.note.Services;

import com.example.note.Entity.Notes.Notes;
import com.example.note.Repository.NotesAudRepository;
import com.example.note.Repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoteService {
    private final NotesRepository notesRepository;
    private final NotesAudRepository audRepository;

    @Autowired
    public NoteService(NotesRepository notesRepository, NotesAudRepository audRepository) {
        this.notesRepository = notesRepository;
        this.audRepository = audRepository;
    }

    public Notes saveNote(Notes note){
        notesRepository.save(note);
        audRepository.save(note);
        return note;
    }

    public Notes putNote(int id, Notes note){
        Notes oldNote = notesRepository.findById(id).orElse(null);
        assert oldNote != null;
        oldNote.setDateChange(note.getDateChange());
        oldNote.setHeading(note.getHeading());
        oldNote.setText(note.getText());
        notesRepository.save(oldNote);
        audRepository.save(oldNote);
        return oldNote;
    }

    public Integer deleteNoteById(int id){
        notesRepository.deleteById(id);
        audRepository.deleteById(id);
        return id;
    }

    public List<Notes> getAllByUserId(int userId){
        return notesRepository.getAllByIdUser(userId);
    }

    public Notes getById(int id){
        return notesRepository.findById(id).orElse(null);
    }
}
