package com.democrud.demo.repositories;


import com.democrud.demo.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends CrudRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE r.role = :login")
    Role getUserByRole(@Param("login") String login);
}