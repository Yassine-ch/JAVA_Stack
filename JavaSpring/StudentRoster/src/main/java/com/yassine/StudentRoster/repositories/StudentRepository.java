package com.yassine.StudentRoster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yassine.StudentRoster.models.Student;
@Repository
public interface StudentRepository  extends CrudRepository<Student, Long>{
List<Student> findAll();
}
