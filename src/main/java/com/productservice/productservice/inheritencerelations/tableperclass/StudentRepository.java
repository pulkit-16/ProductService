package com.productservice.productservice.inheritencerelations.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @Override
    Student  save(Student student);
}
