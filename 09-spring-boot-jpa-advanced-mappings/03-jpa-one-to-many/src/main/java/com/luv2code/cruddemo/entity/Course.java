package com.luv2code.cruddemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="course")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Course {

  // define our field
  private int id;

  private String title;

  private Instructor instructor;

  // define constructor


  public Course(String title) {
    this.title = title;
  }
}
