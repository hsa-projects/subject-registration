package de.hochschule.augsburg.subject.domain.model;

import de.hochschule.augsburg.registration.domain.model.RegistrationUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class Subject {

    private final String id;

    private final String name;

    private String professor;

    private Integer creditPoints;

    private String description;

    private String specialization;

    public void assignProfessor(final String professor) {
        this.professor = professor;
    }

    public void update(final SubjectUpdate update) {
        this.professor = update.getProfessor();
        this.creditPoints = update.getCreditPoints();
        this.description = update.getDescription();
        this.specialization = update.getSpecialization();
    }
}
