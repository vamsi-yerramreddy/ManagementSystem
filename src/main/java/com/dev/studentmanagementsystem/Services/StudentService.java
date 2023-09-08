package com.dev.studentmanagementsystem.Services;

import com.dev.studentmanagementsystem.Models.Student;
import com.dev.studentmanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public List<Student> getAllStudents(){
       return studentRepository.findAll();

    }
    public Student saveStudent(Student student){
        return  studentRepository.save(student);
    }
    public Student getStudentById(Long id){
        return studentRepository.getStudentByRollNo(id);
    }

    public void deleteStudentById(Long id){
        studentRepository.deleteByRollNo(id);

    }

    public List<Student> searchStudents(String query){
        return studentRepository.
                findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(query,query,query);
    }
}
