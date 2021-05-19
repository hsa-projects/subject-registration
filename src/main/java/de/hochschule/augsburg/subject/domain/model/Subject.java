package de.hochschule.augsburg.subject.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class Subject {

    private final String id;

    private final String name;

    private final String professor;

    private final String creditPoints;

    private final String description;

    private final String specialization;
}
