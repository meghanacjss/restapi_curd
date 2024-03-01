package com.example.SpringPro.Controller;

import com.example.SpringPro.Entity.Student;
import com.example.SpringPro.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
//    @PostMapping("/addStudent")
//    public Student postDetails(@RequestBody Student student){
//        return studentService.saveDetails(student);
//
//    }

    @PostMapping("/addStudent")
    public String postDetails(@RequestBody Student student){
         studentService.saveDetails(student);
         return "details posted";
    }

    @GetMapping("/getAllStudents")
    public List<Student> getDetails(){
        return studentService.getAllDetails();
    }
@GetMapping("/getStudentById/{id}")
    public Student fetchDetailsById(@PathVariable int id){
        return studentService.getStudentById(id);
    }
    @PutMapping("/updateStudent")
    public Student updateStudentDetails(@RequestBody Student student){
        return studentService.updateDetails(student);

    }
    @DeleteMapping("/deleteStudent/{id}")
    public String deleteDetails(@PathVariable int id){
        return studentService.deleteStudent(id);

    }
}
