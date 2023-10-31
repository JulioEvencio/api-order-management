package com.github.julioevencio.apiordermanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.julioevencio.apiordermanagement.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
