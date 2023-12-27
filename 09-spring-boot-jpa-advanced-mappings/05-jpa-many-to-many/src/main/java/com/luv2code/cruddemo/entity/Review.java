package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "review")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Review {

  // define fields, constructors, getters and setters, toString, annotate fields

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "comment")
  private String comment;

  public Review(String comment) {
    this.comment = comment;

  }
}
