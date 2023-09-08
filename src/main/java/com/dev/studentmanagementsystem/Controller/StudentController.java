package com.dev.studentmanagementsystem.Controller;

import com.dev.studentmanagementsystem.Models.Student;
import com.dev.studentmanagementsystem.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String listAllStudents(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }
    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        Student s1= new Student();
        model.addAttribute("fuckthisshit",s1);
        return "create_student";

    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }
    @GetMapping("/students/search")
    public String searchStudents(@RequestParam("query")String query, Model model){
        List<Student> searchStudents=studentService.searchStudents(query);
        model.addAttribute("searchStudents",searchStudents);
        return "student_list";
    }

    @PostMapping("/students/{id}")
    public String UpdateStudent(@PathVariable Long id ,
                                @ModelAttribute("student") Student student,
                                Model model){
        Student oldStudent= studentService.getStudentById(id);
        oldStudent.setRollNo(id);
        oldStudent.setEmail(student.getEmail());
        oldStudent.setFirstName(student.getFirstName());
        oldStudent.setLastName(student.getLastName());
        studentService.saveStudent(oldStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    @Transactional
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return  "redirect:/students";
    }
}
