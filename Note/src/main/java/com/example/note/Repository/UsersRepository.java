package com.example.note.Repository;

import com.example.note.Entity.Users.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {
    @Override
    Optional<Users> findById(Integer id);

    Optional<Users> findByUsername(String username);
}
