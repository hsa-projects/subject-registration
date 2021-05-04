package de.hochschule.augsburg.registration.domain.mapper;

import de.hochschule.augsburg.registration.domain.model.Registration;
import de.hochschule.augsburg.registration.infrastructure.entity.RegistrationEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RegistrationMapper {

    RegistrationEntity map(Registration registration);

    List<Registration> map(List<RegistrationEntity> entityList);

    Registration map(RegistrationEntity registration);

}
