package com.infnet.spring.jpa.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infnet.spring.jpa.h2.model.Autor;



public interface AutorRepository extends JpaRepository<Autor, Long> {

  List<Autor> findByNomeContainingIgnoreCase(String title);
}
