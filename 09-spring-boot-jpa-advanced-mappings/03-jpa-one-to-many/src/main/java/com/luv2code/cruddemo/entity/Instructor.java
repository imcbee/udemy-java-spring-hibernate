package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="instructor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Instructor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "instructor_detail_id")
  private InstructorDetail instructorDetail;

  @OneToMany(mappedBy = "instructor",
             fetch = FetchType.LAZY,
             cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
  private List<Course> courses;

  public Instructor(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  // Add convenience methods for bi-directional relationship
  public void add(Course tempCourse) {
    if(courses == null) {
      courses = new ArrayList<>();
    }
    courses.add(tempCourse);

    tempCourse.setInstructor(this);
  }

}
