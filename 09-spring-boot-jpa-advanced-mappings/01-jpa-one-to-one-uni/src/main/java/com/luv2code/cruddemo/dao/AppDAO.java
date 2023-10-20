package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;

public interface AppDAO {

  void save(Instructor theInstructor);

  Instructor findByInstructorById(int theId);

  void deleteInstructorById(int theId);
}
