package com.example.note.Services;

import com.example.note.Entity.Users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CurrentModel { //use in UserController, for actions with notes
    private final UserService usersService;
    private Users currentUser;

    @Autowired
    public CurrentModel(UserService usersService) {
        this.usersService = usersService;
    }

    public void uploadCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername ();
        } else {
            username = principal.toString();
        }
        currentUser = usersService.findByUsername (username);
    }

    public Users getCurrentUser(){
        return currentUser;
    }
}
