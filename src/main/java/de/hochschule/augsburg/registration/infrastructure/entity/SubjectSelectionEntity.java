package de.hochschule.augsburg.registration.infrastructure.entity;

import de.hochschule.augsburg.subject.infrastructure.entity.SubjectEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "hsa_subject_selection")
public class SubjectSelectionEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", unique = true, nullable = false, updatable = false, columnDefinition = "BINARY(16)")
    private UUID id;


    @ManyToOne
    @JoinColumn(name = "registration_id")
    private RegistrationEntity registration;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

    //Registration ID

    @Column(name = "points", nullable = false, columnDefinition = "smallint")
    private Integer points;

}
