package de.hochschule.augsburg.registration.domain.model;


import de.hochschule.augsburg.subject.domain.model.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class SubjectSelection {

    private final UUID id;

    private final Registration registration;

    private final Subject subject;

    private final Integer points;

}
