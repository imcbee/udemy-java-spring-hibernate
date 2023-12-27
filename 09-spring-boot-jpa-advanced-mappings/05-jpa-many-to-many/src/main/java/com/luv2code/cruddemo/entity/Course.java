package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Course {

  // define our field
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "title")
  private String title;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
  @JoinColumn(name = "instructor_id")
  private Instructor instructor;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "course_id")
  private List<Review> reviews;

  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
  @JoinTable(
    name = "course_student",
    joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id")
  )
  private List<Student> students;

  // define constructor


  public Course(String title) {
    this.title = title;
  }

   // add convenience method

  public void addReview(Review theReview) {
    if (reviews == null) {
      reviews = new ArrayList<>();
    }

    reviews.add(theReview);
  }

  public void addStudent(Student theStudent) {
    if(students == null) {
      students = new ArrayList<>();
    }

    students.add(theStudent);
  }

}
