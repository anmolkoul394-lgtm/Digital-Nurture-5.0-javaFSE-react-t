package com.dn5.week2.repository;

import com.dn5.week2.entity.Employee;
import com.dn5.week2.projection.EmployeeSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Module 6 -> "Spring Data Repositories", "CRUD Operations with Spring Data
 * JPA", "Query Methods and Named Queries", "Pagination and Sorting", and
 * "Spring Data JPA Projections" — all demonstrated in this single repository.
 *
 * Extending JpaRepository already provides full CRUD (save, findById,
 * findAll, deleteById, ...) for free.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // ---- Derived query methods (Spring parses the method name into SQL) ----
    List<Employee> findByDesignation(String designation);

    List<Employee> findByDepartmentId(Long departmentId);

    List<Employee> findBySalaryGreaterThan(Double salary);

    Optional<Employee> findByEmail(String email);

    // ---- Pagination + Sorting ----
    Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);

    // ---- Custom JPQL query with @Query (Query DSL / custom query methods) ----
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :min AND :max")
    List<Employee> findEmployeesInSalaryRange(@Param("min") Double min, @Param("max") Double max);

    // ---- Native SQL query variant ----
    @Query(value = "SELECT * FROM employees WHERE designation = :designation ORDER BY salary DESC",
           nativeQuery = true)
    List<Employee> findByDesignationNative(@Param("designation") String designation);

    // ---- Interface-based projection: only fetches id, name, designation ----
    List<EmployeeSummary> findByDepartmentName(String departmentName);
}
