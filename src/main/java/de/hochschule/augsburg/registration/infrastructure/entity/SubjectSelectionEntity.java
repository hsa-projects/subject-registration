package de.hochschule.augsburg.registration.infrastructure.entity;

import de.hochschule.augsburg.subject.infrastructure.SubjectEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "hsa_subject_selection")
public class SubjectSelectionEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", unique = true, nullable = false, updatable = false, length = 36)
    private String id;

    @Column(name="subject_id", nullable = false)
    private String subject;

    //Registration ID

    @Column(name = "points", nullable = false)
    private Integer points;

}
