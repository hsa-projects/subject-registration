package de.hochschule.augsburg.registration.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class RegistrationUpdate {

    private final UUID id;

    private final List<SubjectSelection> subjectSelection = new ArrayList<>();

}
