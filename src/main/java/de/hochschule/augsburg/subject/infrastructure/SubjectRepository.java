package de.hochschule.augsburg.subject.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface SubjectRepository extends JpaRepository<SubjectEntity, String> {
}
