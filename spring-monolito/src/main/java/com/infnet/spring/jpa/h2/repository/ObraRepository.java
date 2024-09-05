package com.infnet.spring.jpa.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infnet.spring.jpa.h2.model.Obra;

public interface ObraRepository extends JpaRepository<Obra, Long> {

  List<Obra> findByNomeContainingIgnoreCase(String nome);
}
