package com.infnet.spring.jpa.h2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "description")
  private String description;


  public Autor() {

  }

  public Autor(String nome, String description) {
    this.nome = nome;
    this.description = description;
  }

  public long getId() {
    return id;
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
    return "Autor [id=" + id + ", nome=" + nome + ", desc=" + description +  "]";
  }

}
