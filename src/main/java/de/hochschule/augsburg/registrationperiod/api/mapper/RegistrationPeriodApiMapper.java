package de.hochschule.augsburg.registrationperiod.api.mapper;

import de.hochschule.augsburg.registrationperiod.api.transport.NewRegistrationPeriodTO;
import de.hochschule.augsburg.registrationperiod.api.transport.RegistrationPeriodTO;
import de.hochschule.augsburg.registrationperiod.api.transport.RegistrationPeriodUpdateTO;
import de.hochschule.augsburg.registrationperiod.domain.model.RegistrationPeriod;
import de.hochschule.augsburg.registrationperiod.domain.model.RegistrationPeriodUpdate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RegistrationPeriodApiMapper {
    List<RegistrationPeriodTO> map(List<RegistrationPeriod> registrationPeriods);

    RegistrationPeriod map(NewRegistrationPeriodTO newRegistrationPeriod);

    RegistrationPeriodUpdate map(RegistrationPeriodUpdateTO update);

    RegistrationPeriodTO map(RegistrationPeriod registrationPeriod);
}
