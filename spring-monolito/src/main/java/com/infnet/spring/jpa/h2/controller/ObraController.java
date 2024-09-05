package com.infnet.spring.jpa.h2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infnet.spring.jpa.h2.model.Obra;
import com.infnet.spring.jpa.h2.repository.ObraRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ObraController {

  @Autowired
  ObraRepository obraRepository;

  @GetMapping("/obra")
  public ResponseEntity<List<Obra>> getAll(@RequestParam(required = false) String title) {
    try {
      List<Obra> obras = new ArrayList<Obra>();

      if (title == null)
      obraRepository.findAll().forEach(obras::add);
      else
      obraRepository.findByNomeContainingIgnoreCase(title).forEach(obras::add);

      if (obras.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(obras, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/obra/{id}")
  public ResponseEntity<Obra> getObralById(@PathVariable("id") long id) {
    Optional<Obra> obraId = obraRepository.findById(id);

    if (obraId.isPresent()) {
      return new ResponseEntity<>(obraId.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/obra")
  public ResponseEntity<Obra> create(@RequestBody Obra obra) {
    try {
      Obra _obra = obraRepository.save(obra);
      return new ResponseEntity<>(_obra, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @DeleteMapping("/obra/{id}")
  public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
    try {
      obraRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


}
