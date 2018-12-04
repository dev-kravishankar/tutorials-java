package com.krs.tutorials.rest.springboot.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.krs.tutorials.rest.springboot.jpa.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	List<Author> findByFirstNameContaining(@Param("fname") String fname);

	List<Author> findByFirstNameOrLastName(@Param("fname") String fname, @Param("lname") String lname);

	List<Author> findByFirstNameContainingOrLastNameContaining(@Param("fname") String fname,
			@Param("lname") String lname);
}
