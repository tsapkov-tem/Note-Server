package com.example.note.Security;

import com.example.note.Entity.Users.Users;
import com.example.note.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Autowired
    public UserDetailsServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> usersOptional = usersRepository.findByUsername (username);
        Users user = usersOptional.orElseThrow(() -> new UsernameNotFoundException ("User doesn't exist"));
        return UserSecurity.fromUser (user);
    }
}
