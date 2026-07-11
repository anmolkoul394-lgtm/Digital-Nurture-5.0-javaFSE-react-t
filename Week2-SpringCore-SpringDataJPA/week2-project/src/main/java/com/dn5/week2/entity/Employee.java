package com.dn5.week2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * Module 6 -> "Entity Mapping" + "Auditing with Spring Data JPA" subtopics.
 *
 * - @Entity / @Table / @Id / @GeneratedValue: basic entity-to-table mapping.
 * - @ManyToOne / @JoinColumn: relationship mapping to Department.
 * - @EntityListeners(AuditingEntityListener.class) + @CreatedDate /
 *   @LastModifiedDate / @CreatedBy / @LastModifiedBy: automatic auditing,
 *   powered by @EnableJpaAuditing in Week2Application and the
 *   AuditorAware bean in JpaAuditingConfig.
 */
@Entity
@Table(name = "employees")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @Email(message = "Email must be valid")
    @Column(nullable = false, unique = true)
    private String email;

    @Positive(message = "Salary must be positive")
    private Double salary;

    private String designation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;
}
