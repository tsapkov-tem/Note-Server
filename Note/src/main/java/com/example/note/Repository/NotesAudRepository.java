package com.example.note.Repository;

import com.example.note.Entity.Notes.Notes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesAudRepository extends JpaRepository<Notes, Integer>, RevisionRepository<Notes,Integer,Integer>{ //Repository for Note's auditions
}
