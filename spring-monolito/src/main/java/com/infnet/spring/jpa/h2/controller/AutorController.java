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

import com.infnet.spring.jpa.h2.model.Autor;
import com.infnet.spring.jpa.h2.repository.AutorRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/old")
public class AutorController {

  @Autowired
  AutorRepository autorRepository;

  @GetMapping("/autor")
  public ResponseEntity<List<Autor>> getAllAutor(@RequestParam(required = false) String title) {
    try {
      List<Autor> autores = new ArrayList<Autor>();

      if (title == null)
      autorRepository.findAll().forEach(autores::add);
      else
      autorRepository.findByNomeContainingIgnoreCase(title).forEach(autores::add);

      if (autores.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(autores, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/autor/{id}")
  public ResponseEntity<Autor> getAutorlById(@PathVariable("id") long id) {
    Optional<Autor> AutorId = autorRepository.findById(id);

    if (AutorId.isPresent()) {
      return new ResponseEntity<>(AutorId.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/autor")
  public ResponseEntity<Autor> createAutor(@RequestBody Autor autor) {
    try {
      Autor _autor = autorRepository.save(new Autor(autor.getNome(), autor.getDescription()));
      return new ResponseEntity<>(_autor, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @DeleteMapping("/autor/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
    try {
      autorRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


}
