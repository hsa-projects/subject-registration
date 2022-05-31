package de.hochschule.augsburg.registration.infrastructure.repository;

import de.hochschule.augsburg.registration.infrastructure.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RegistrationRepository extends JpaRepository<RegistrationEntity, UUID> {

    Optional<RegistrationEntity> findByStudent(String student);

}
