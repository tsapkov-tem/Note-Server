package com.example.note.Repository;

import com.example.note.Entity.Notes.Notes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotesRepository extends CrudRepository<Notes, Integer> {
    List<Notes> getAllByIdUser(int userId);

}
