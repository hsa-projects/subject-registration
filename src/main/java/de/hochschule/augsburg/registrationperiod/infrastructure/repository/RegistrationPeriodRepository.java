package de.hochschule.augsburg.registrationperiod.infrastructure.repository;

import de.hochschule.augsburg.registrationperiod.infrastructure.entity.RegistrationPeriodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationPeriodRepository extends JpaRepository<RegistrationPeriodEntity, String> {

}
