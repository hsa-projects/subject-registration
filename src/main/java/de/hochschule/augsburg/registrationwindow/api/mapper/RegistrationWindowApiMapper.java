package de.hochschule.augsburg.registrationwindow.api.mapper;

import de.hochschule.augsburg.registrationwindow.api.transport.NewRegistrationWindowTO;
import de.hochschule.augsburg.registrationwindow.api.transport.RegistrationWindowTO;
import de.hochschule.augsburg.registrationwindow.api.transport.RegistrationWindowUpdateTO;
import de.hochschule.augsburg.registrationwindow.domain.model.RegistrationWindow;
import de.hochschule.augsburg.registrationwindow.domain.model.RegistrationWindowUpdate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RegistrationWindowApiMapper {
    List<RegistrationWindowTO> map(List<RegistrationWindow> registrationWindows);

    RegistrationWindow map(NewRegistrationWindowTO newRegistrationPeriod);

    RegistrationWindowUpdate map(RegistrationWindowUpdateTO update);

    RegistrationWindowTO map(RegistrationWindow registrationWindow);
}
