package com.springbootcrud.springbootcrud.controller;

import com.springbootcrud.springbootcrud.entity.Student;
import com.springbootcrud.springbootcrud.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity<Student> saveOneStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveOneStudent(student);
        return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getOneStudent(@PathVariable Long studentId) {
        Student foundStudent = studentService.getOneStudent(studentId);
        return new ResponseEntity<Student>(foundStudent, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> allStudents = studentService.getAllStudents();
        return new ResponseEntity<List<Student>>(allStudents, HttpStatus.OK);
    }

    @GetMapping("/delete/{studentId}")
    public ResponseEntity<Void> deleteOneStudent(@PathVariable Long studentId) {
        studentService.deleteOneStudent(studentId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

}
