package de.hochschule.augsburg.subject.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class SubjectUpdate {
    private final UUID id;

    private final String name;

    private final String professor;

    private final Float creditPoints;

    private final String description;

    private final String specialization;
}