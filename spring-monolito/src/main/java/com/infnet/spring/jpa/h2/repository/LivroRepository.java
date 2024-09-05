package com.infnet.spring.jpa.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infnet.spring.jpa.h2.model.Livros;

public interface LivroRepository extends JpaRepository<Livros, Long> {
  List<Livros> findByPublished(boolean published);

  List<Livros> findByTitleContainingIgnoreCase(String title);
}
