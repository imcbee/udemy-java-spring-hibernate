package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="instructor_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InstructorDetail {

  // annotate the class as an entity and map to db table

  // define the fields
  // annotate the fields with db column names
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "youtube_channel")
  private String youtubeChannel;

  @Column(name = "hobby")
  private String hobby;

  @OneToOne(mappedBy = "instructorDetail",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
  private Instructor instructor;

  // create constructors
  public InstructorDetail(String youtubeChannel, String hobby) {
    this.youtubeChannel = youtubeChannel;
    this.hobby = hobby;
  }

  // generate getter/setter methods

  // generate toString() method
}
