package com.capgemini.training.repository.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity implements Serializable {

  protected static final long serialVersionUID = 7418251777718397333L;

  @NotNull @CreatedDate private ZonedDateTime creationDate;

  @NotNull @LastModifiedDate ZonedDateTime updatedDate;
}
