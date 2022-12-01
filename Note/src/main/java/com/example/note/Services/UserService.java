package com.example.note.Services;

import com.example.note.Entity.Notes.Notes;
import com.example.note.Entity.Users.Users;
import com.example.note.Repository.NotesAudRepository;
import com.example.note.Repository.NotesRepository;
import com.example.note.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UsersRepository usersRepository;
    private final NotesRepository notesRepository;
    private final PasswordEncoder passwordEncoder;
    private final NotesAudRepository audRepository;

    @Autowired
    public UserService(UsersRepository usersRepository, NotesRepository notesRepository, PasswordEncoder passwordEncoder, NotesAudRepository audRepository) {
        this.usersRepository = usersRepository;
        this.notesRepository = notesRepository;
        this.passwordEncoder = passwordEncoder;
        this.audRepository = audRepository;
    }

    public Users findByUsername(String username) {
        return usersRepository.findByUsername(username).orElse(null);
    }

    public Users saveUser(Users user){
        user.setPassword(passwordEncoder.encode (user.getPassword()));
        usersRepository.save(user);
        return user;
    }

    public Integer deleteUser(int id){
        usersRepository.deleteById(id);
        List<Notes> list = notesRepository.getAllByIdUser(id);
        notesRepository.deleteAll(list);
        audRepository.deleteAll(list);
        return id;
    }

    public Users putUser (int id, Users user){
        Users oldUser = usersRepository.findById(id).orElse(null);
        assert oldUser != null;
        oldUser.setIdUser(user.getIdUser());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(passwordEncoder.encode (user.getPassword()));
        oldUser.setRole(user.getRole());
        usersRepository.save(oldUser);
        return oldUser;
    }
}
