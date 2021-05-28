package de.hochschule.augsburg.subject.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SubjectUpdate {
    private final String id;

    private final String professor;

    private final Integer creditPoints;

    private final String description;

    private final String specialization;
}
