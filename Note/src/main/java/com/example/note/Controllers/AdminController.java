package com.example.note.Controllers;

import com.example.note.Entity.Users.Users;
import com.example.note.Services.UserService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@Api(tags = {"Admin controller"})
@Tag(name = "Simple server", description = "Note server")
@PreAuthorize("hasAuthority('all')") //Controller only for ADMINS
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public Users SaveUser(@RequestBody Users user){
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public Users RefreshUser(@RequestBody Users user, @PathVariable int id){
        return userService.putUser(id,user);
    }


    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable int id){
        return userService.deleteUser(id);
    }
}
