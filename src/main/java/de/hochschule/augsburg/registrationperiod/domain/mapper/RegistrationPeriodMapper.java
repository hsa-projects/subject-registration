package de.hochschule.augsburg.registrationperiod.domain.mapper;

import de.hochschule.augsburg.registrationperiod.domain.model.RegistrationPeriod;
import de.hochschule.augsburg.registrationperiod.infrastructure.entity.RegistrationPeriodEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RegistrationPeriodMapper {
    RegistrationPeriodEntity map(RegistrationPeriod registrationPeriod);

    RegistrationPeriod map(RegistrationPeriodEntity registrationPeriod);

    List<RegistrationPeriod> map(List<RegistrationPeriodEntity> entityList);

}
