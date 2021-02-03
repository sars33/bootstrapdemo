package com.democrud.demo.repositories;

import com.democrud.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    public List<User> findAll();

    @Query("SELECT u FROM User u WHERE u.email = :login")
    User getUserByEmail(@Param("login") String login);

}
