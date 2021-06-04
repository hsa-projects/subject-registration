package de.hochschule.augsburg.registration.infrastructure.repository;

import de.hochschule.augsburg.registration.infrastructure.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<RegistrationEntity, String> {

    RegistrationEntity findByStudent(String student);

}
