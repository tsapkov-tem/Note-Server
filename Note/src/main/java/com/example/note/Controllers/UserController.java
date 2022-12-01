package com.example.note.Controllers;

import com.example.note.Entity.Notes.Notes;
import com.example.note.Entity.Users.Users;
import com.example.note.Services.CurrentModel;
import com.example.note.Services.NoteService;
import com.example.note.Services.UserService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Api(tags = {"User controller"})
@Tag(name = "Simple server", description = "Note server")
@PreAuthorize ("hasAnyAuthority('user', 'all')") //Main controller for using notes
public class UserController {
    private final UserService userService;

    private final CurrentModel currentModel;
    private final NoteService noteService;

    @Autowired
    public UserController(UserService userService, CurrentModel currentModel, NoteService noteService) {
        this.userService = userService;
        this.currentModel = currentModel;
        this.noteService = noteService;
    }

    @GetMapping("/")
    public Users getUser(){
        return currentModel.getCurrentUser();
    }

    @PutMapping("/")
    public Users putUser(@RequestParam String pass,@RequestParam String username){
        Users oldUser = currentModel.getCurrentUser();
        oldUser.setUsername(username);
        oldUser.setPassword(pass);
        userService.saveUser(oldUser);
        return oldUser;
    }

    @GetMapping("/notes")
    public List<Notes> getAllNotesForUser(){
        return noteService.getAllByUserId(currentModel.getCurrentUser().getIdUser());
    }

    @GetMapping("/notes/{id}")
    public Notes getNote(@PathVariable int id){
        return noteService.getById(id);
    }

    @PostMapping("/notes")
    public Notes saveNote(@RequestBody Notes notes){
        Notes newNote = new Notes();
        newNote.setIdUser(currentModel.getCurrentUser().getIdUser());
        newNote.setText(notes.getText());
        newNote.setHeading(notes.getHeading());
        newNote.setDateCreation(notes.getDateCreation());
        newNote.setDateChange(notes.getDateChange());
        return noteService.saveNote(newNote);
    }

    @PutMapping("/notes/{id}")
    public Notes putNote(@PathVariable int id, @RequestBody Notes notes){
        return noteService.putNote(id,notes);
    }

    @DeleteMapping("/notes/{id}")
    public Integer deleteNote(@PathVariable int id){
        return noteService.deleteNoteById(id);
    }
}
