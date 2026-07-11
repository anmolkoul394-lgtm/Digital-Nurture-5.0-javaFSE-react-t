package com.dn5.week2.projection;

/**
 * Module 6 -> "Spring Data JPA Projections" subtopic.
 * Interface-based projection: only the getters declared here are fetched
 * from the database, so heavier columns (salary, audit fields, etc.) are
 * left out of the query entirely.
 */
public interface EmployeeSummary {
    Long getId();
    String getName();
    String getDesignation();
}
