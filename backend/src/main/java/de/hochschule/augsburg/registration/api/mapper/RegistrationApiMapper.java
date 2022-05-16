package de.hochschule.augsburg.registration.api.mapper;

import de.hochschule.augsburg.registration.api.transport.NewRegistrationTO;
import de.hochschule.augsburg.registration.api.transport.RegistrationTO;
import de.hochschule.augsburg.registration.api.transport.RegistrationUpdateTO;
import de.hochschule.augsburg.registration.domain.model.Registration;
import de.hochschule.augsburg.registration.domain.model.RegistrationUpdate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RegistrationApiMapper {

    List<RegistrationTO> map(List<Registration> registrations);

    Registration map(NewRegistrationTO newRegistration);

    RegistrationUpdate map(RegistrationUpdateTO update);

    RegistrationTO map(Registration registration);

}
