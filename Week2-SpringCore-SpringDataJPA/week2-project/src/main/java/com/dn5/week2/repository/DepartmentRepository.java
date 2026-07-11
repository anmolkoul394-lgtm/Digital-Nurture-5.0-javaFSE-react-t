package com.dn5.week2.repository;

import com.dn5.week2.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Module 6 -> "Spring Data Repositories" subtopic.
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByName(String name);
}
