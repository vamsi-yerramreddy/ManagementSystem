package com.dev.studentmanagementsystem.Repository;

import com.dev.studentmanagementsystem.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();
    Student save(Student student);
    Student getStudentByRollNo(Long id);
    void deleteByRollNo(Long id);
    List<Student> findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String query1,
                                                                                                                  String query2,
                                                                                                                  String query3
                                                                                                                  );

}
