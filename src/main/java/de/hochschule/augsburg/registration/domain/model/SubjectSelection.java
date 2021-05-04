package de.hochschule.augsburg.registration.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class SubjectSelection {

    private final String id;

    private final String subject;

    private final Integer points;

}
