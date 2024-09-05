package com.infnet.spring.jpa.h2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "obra")
public class Obra {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "idAutor")
  private Long idAutor;

  @Column(name = "nome")
  private String nome;

  @Column(name = "description")
  private String description;


  public Obra() {

  }

  public Obra(String nome, Long idAutor, String description) {
    this.idAutor = idAutor;
    this.nome = nome;
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public long getIdAutor() {
    return idAutor;
  }

  public void setIdAutor(Long idAutor) {
    this.idAutor = idAutor;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }



  @Override
  public String toString() {
    return "Obra [id=" + id + ", nome=" + nome + ", desc=" + description +  "]";
  }

}
