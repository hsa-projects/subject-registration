package de.hochschule.augsburg.subject.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "hsa_subject_tbl")
public class SubjectEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    //@Type(type="BINARY(10)")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "professor", nullable = false)
    private String professor;

    @Column(name = "cp", nullable = false)
    private Integer creditPoints;

    @Column(name= "description", nullable = true)
    private String description;

    @Column(name = "specialization", nullable = true)
    private String specialization;
}
