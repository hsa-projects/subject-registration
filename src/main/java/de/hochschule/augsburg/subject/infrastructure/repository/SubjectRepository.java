package de.hochschule.augsburg.subject.infrastructure.repository;

import de.hochschule.augsburg.subject.infrastructure.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SubjectRepository extends JpaRepository<SubjectEntity, String> {
    List<SubjectEntity> findAllByProfessor(String professor);

    List<SubjectEntity> findAllBySpecialization(String spezialization);

    List<SubjectEntity> findAllByCreditPoints(Byte creditPoints);

    void deleteSubjectByName(String name);
}
