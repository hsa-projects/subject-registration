package de.hochschule.augsburg.registrationWindow.infrastructure.repository;

import de.hochschule.augsburg.registrationWindow.infrastructure.entity.RegistrationWindowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationWindowRepository extends JpaRepository<RegistrationWindowEntity, String> {

}
