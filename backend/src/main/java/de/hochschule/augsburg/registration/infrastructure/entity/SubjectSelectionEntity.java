package de.hochschule.augsburg.registration.infrastructure.entity;

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
    @Column(name = "id", unique = true, nullable = false, updatable = false, columnDefinition = "uuid")
    private UUID id;

    @Column(name="subject_id", nullable = false)
    private UUID subject;

    //Registration ID
    @OneToOne
    @JoinColumn(name="registration_id", nullable = false)
    private RegistrationEntity registrationEntity;


    @Column(name = "points", nullable = false)
    private Integer points;

}
