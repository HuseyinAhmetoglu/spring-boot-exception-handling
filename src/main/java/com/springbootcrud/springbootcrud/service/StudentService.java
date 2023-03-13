package com.springbootcrud.springbootcrud.service;

import com.springbootcrud.springbootcrud.entity.Student;
import com.springbootcrud.springbootcrud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveOneStudent(Student student){
        Student savedStudent = studentRepository.save(student);
        return savedStudent;
    }

    public Student getOneStudent(Long studentId){
        Student foundStudent = studentRepository.findById(studentId).get();
        return foundStudent;
    }

    public List<Student> getAllStudents(){
        List<Student> allStudents = studentRepository.findAll();
        return allStudents;
    }

    public void deleteOneStudent(Long studentId){
        studentRepository.deleteById(studentId);
    }
}
