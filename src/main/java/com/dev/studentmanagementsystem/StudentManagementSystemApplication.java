package com.dev.studentmanagementsystem;

import com.dev.studentmanagementsystem.Models.Student;
import com.dev.studentmanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;


    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
    }
    public void run(String ... varargs){
        Student s1 = new Student(1L,"Ram","Mohan","junk@gmail.com");
        Student s2 = new Student(2L,"Arun","Rao","arjun@gmail.com");
        Student s3= new Student(3L,"John","Cena","John.cena@gmail.com");
        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);
    }
}
