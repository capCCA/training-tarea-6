package com.capgemini.training.commons.config;

import static java.time.ZoneOffset.UTC;

import java.time.ZonedDateTime;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@AllArgsConstructor
@EnableJpaAuditing(dateTimeProviderRef = "auditingDateTimeProvider")
public class PersistenceConfig {

  @Bean
  public DateTimeProvider auditingDateTimeProvider() {
    return () -> Optional.of(ZonedDateTime.now(UTC));
  }
}
