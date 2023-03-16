package com.springbootcrud.springbootcrud.service;

import com.springbootcrud.springbootcrud.entity.Student;
import com.springbootcrud.springbootcrud.exception.StudentNotFoundException;
import com.springbootcrud.springbootcrud.exception.StudentNotNullException;
import com.springbootcrud.springbootcrud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveOneStudent(Student student) {
        if (student.getName().isBlank() || student.getName().isEmpty()) {
            throw new StudentNotNullException("Student name must be not null!");
        }
        if (student.getSurname().isBlank() || student.getSurname().isEmpty()) {
            throw new StudentNotNullException("Student surname must be not null!");
        }
        return studentRepository.save(student);
    }

    public Student getOneStudent(Long studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Student student = optionalStudent.orElseThrow(() -> new StudentNotFoundException("Student id: " + studentId));
        return student;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteOneStudent(Long studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Student student = optionalStudent.orElseThrow(() -> new StudentNotFoundException("Student id: " + studentId));
        studentRepository.deleteById(studentId);
    }
}
