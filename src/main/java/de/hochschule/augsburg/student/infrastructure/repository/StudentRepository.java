package de.hochschule.augsburg.student.infrastructure.repository;

import de.hochschule.augsburg.student.infrastructure.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentRepository extends JpaRepository<StudentEntity, String> {
}
