package com.springbootcrud.springbootcrud.repository;

import com.springbootcrud.springbootcrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
