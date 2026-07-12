// AuditConfig.java
// @EnableJpaAuditing switches auditing on globally.
// AuditorAware tells Spring who the "current user" is for @CreatedBy/@LastModifiedBy -
// in a real app this would read from Spring Security's SecurityContext instead of a fixed value.

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class AuditConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.of("system-user");
    }
}
