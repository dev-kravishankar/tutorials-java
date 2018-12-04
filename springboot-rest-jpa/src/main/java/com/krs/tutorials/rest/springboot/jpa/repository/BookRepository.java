package com.krs.tutorials.rest.springboot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krs.tutorials.rest.springboot.jpa.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
