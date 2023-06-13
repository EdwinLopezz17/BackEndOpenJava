package com.acme.learning.platform.learning.domain.model;

import com.acme.learning.platform.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "criteria")
public class Criterion extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotBlank
    private String name;

    //relationships
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="skill_id", nullable = false)
    @JsonIgnore
    private Skill skill;
}
