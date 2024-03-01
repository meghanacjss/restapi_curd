package com.example.SpringPro.Service;

import com.example.SpringPro.Entity.Student;
import com.example.SpringPro.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public Student saveDetails(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAllDetails(){
        return studentRepo.findAll();
    }

    public Student getStudentById(int id){
        return studentRepo.findById(id).orElse(null);
    }
//    public Student updateDetails(Student student) {
//
//        Student updateStudent = studentRepo.findById(student.getId()).orElse(null);
//        if (updateStudent != null) {
//            updateStudent.setMark(student.getMark());
//            updateStudent.setName(student.getName());
//            studentRepo.save(updateStudent);
//            return updateStudent;
//        }
//        return null;
//    }

    public Student updateDetails(Student student) {
        return studentRepo.findById(student.getId())
                .map(updateStudent -> {
                    updateStudent.setMark(student.getMark());
                    updateStudent.setName(student.getName());
                    return studentRepo.save(updateStudent);
                })
                .orElse(null);
    }

    public String deleteStudent(int id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
            return "deleted " + id;
        }else{
            return "id is not exist";
        }
    }
}
