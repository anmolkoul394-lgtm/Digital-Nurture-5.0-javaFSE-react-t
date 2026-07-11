package com.dn5.week2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * Module 6 -> "Auditing with Spring Data JPA" subtopic.
 * Supplies the "current user" for @CreatedBy / @LastModifiedBy.
 * In a real app this would read the authenticated user from Spring Security's
 * SecurityContext; here it's hard-coded to keep the demo self-contained.
 */
@Configuration
public class JpaAuditingConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.of("system-demo-user");
    }
}
