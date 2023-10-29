package com.github.julioevencio.apiordermanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.julioevencio.apiordermanagement.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
