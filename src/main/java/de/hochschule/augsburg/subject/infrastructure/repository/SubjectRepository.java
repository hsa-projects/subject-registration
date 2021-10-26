package de.hochschule.augsburg.subject.infrastructure.repository;

import de.hochschule.augsburg.subject.infrastructure.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface SubjectRepository extends JpaRepository<SubjectEntity, UUID> {

    SubjectEntity findByName(String name);

    void deleteSubjectByName(String name);
}
