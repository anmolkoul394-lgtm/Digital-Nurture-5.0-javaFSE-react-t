package com.dn5.week2.service;

import com.dn5.week2.entity.Department;
import com.dn5.week2.entity.Employee;
import com.dn5.week2.exception.ResourceNotFoundException;
import com.dn5.week2.projection.EmployeeSummary;
import com.dn5.week2.repository.DepartmentRepository;
import com.dn5.week2.repository.EmployeeRepository;
import com.dn5.week2.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Module 5 -> "Dependency Injection in Spring" subtopic:
 * - Constructor injection for the two mandatory collaborators (repositories).
 * - @Qualifier resolves which NotificationService bean to inject, since
 *   there are two candidates (EmailNotificationService is @Primary,
 *   "smsNotificationService" is defined in AppConfig).
 *
 * Module 6 -> "CRUD Operations with Spring Data JPA" subtopic: every method
 * below delegates to JpaRepository / custom query methods.
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final NotificationService notificationService;

    // Constructor injection (recommended approach)
    public EmployeeService(EmployeeRepository employeeRepository,
                            DepartmentRepository departmentRepository,
                            @Qualifier("smsNotificationService") NotificationService notificationService) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.notificationService = notificationService;
    }

    public Employee createEmployee(Employee employee, Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found: " + departmentId));
        employee.setDepartment(department);
        Employee saved = employeeRepository.save(employee);
        notificationService.send("New employee onboarded: " + saved.getName());
        return saved;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + id));
    }

    public Employee updateEmployee(Long id, Employee updated) {
        Employee existing = getEmployeeById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setSalary(updated.getSalary());
        existing.setDesignation(updated.getDesignation());
        return employeeRepository.save(existing);
    }

    public void deleteEmployee(Long id) {
        Employee existing = getEmployeeById(id);
        employeeRepository.delete(existing);
    }

    public List<Employee> getByDesignation(String designation) {
        return employeeRepository.findByDesignation(designation);
    }

    public List<Employee> getBySalaryGreaterThan(Double salary) {
        return employeeRepository.findBySalaryGreaterThan(salary);
    }

    public List<Employee> getInSalaryRange(Double min, Double max) {
        return employeeRepository.findEmployeesInSalaryRange(min, max);
    }

    // Pagination + Sorting
    public Page<Employee> getByDepartment(String departmentName, Pageable pageable) {
        return employeeRepository.findByDepartmentName(departmentName, pageable);
    }

    // Projection
    public List<EmployeeSummary> getSummariesByDepartment(String departmentName) {
        return employeeRepository.findByDepartmentName(departmentName);
    }
}
