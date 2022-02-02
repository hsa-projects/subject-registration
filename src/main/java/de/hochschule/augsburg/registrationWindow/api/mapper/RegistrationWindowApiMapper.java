package de.hochschule.augsburg.registrationWindow.api.mapper;

import de.hochschule.augsburg.registrationWindow.api.transport.NewRegistrationWindowTO;
import de.hochschule.augsburg.registrationWindow.api.transport.RegistrationWindowTO;
import de.hochschule.augsburg.registrationWindow.api.transport.RegistrationWindowUpdateTO;
import de.hochschule.augsburg.registrationWindow.domain.model.RegistrationWindow;
import de.hochschule.augsburg.registrationWindow.domain.model.RegistrationWindowUpdate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RegistrationWindowApiMapper {
    List<RegistrationWindowTO> map(List<RegistrationWindow> registrationWindows);

    RegistrationWindow map(NewRegistrationWindowTO newRegistrationPeriod);

    RegistrationWindowUpdate map(RegistrationWindowUpdateTO update);

    RegistrationWindowTO map(RegistrationWindow registrationWindow);
}
