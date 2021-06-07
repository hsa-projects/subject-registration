package de.hochschule.augsburg.registrationwindow.infrastructure.repository;

import de.hochschule.augsburg.registrationwindow.infrastructure.entity.RegistrationWindowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationWindowRepository extends JpaRepository<RegistrationWindowEntity, String> {

}
