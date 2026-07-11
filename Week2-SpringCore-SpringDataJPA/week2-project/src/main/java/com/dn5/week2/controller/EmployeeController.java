package com.dn5.week2.controller;

import com.dn5.week2.entity.Employee;
import com.dn5.week2.projection.EmployeeSummary;
import com.dn5.week2.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Module 5 -> "Spring MVC and ORM" subtopic: Controller Layer, Form
 * Handling / request mapping, Validation, and Exception Handling (delegated
 * to GlobalExceptionHandler).
 *
 * Module 6 -> "Pagination and Sorting" subtopic is demonstrated in
 * getByDepartment().
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee employee,
                                            @RequestParam Long departmentId) {
        Employee created = employeeService.createEmployee(employee, departmentId);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/by-designation")
    public List<Employee> byDesignation(@RequestParam String designation) {
        return employeeService.getByDesignation(designation);
    }

    @GetMapping("/search/salary-above")
    public List<Employee> salaryAbove(@RequestParam Double amount) {
        return employeeService.getBySalaryGreaterThan(amount);
    }

    @GetMapping("/search/salary-range")
    public List<Employee> salaryRange(@RequestParam Double min, @RequestParam Double max) {
        return employeeService.getInSalaryRange(min, max);
    }

    // Pagination + Sorting: /api/employees/by-department?name=IT&page=0&size=5&sortBy=salary&direction=DESC
    @GetMapping("/by-department")
    public Page<Employee> byDepartment(@RequestParam String name,
                                        @RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "5") int size,
                                        @RequestParam(defaultValue = "id") String sortBy,
                                        @RequestParam(defaultValue = "ASC") Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return employeeService.getByDepartment(name, pageable);
    }

    // Projection: returns only id, name, designation
    @GetMapping("/by-department/summary")
    public List<EmployeeSummary> summaryByDepartment(@RequestParam String name) {
        return employeeService.getSummariesByDepartment(name);
    }
}
