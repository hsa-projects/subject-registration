package de.hochschule.augsburg.registrationWindow.domain.mapper;

import de.hochschule.augsburg.registrationWindow.domain.model.RegistrationWindow;
import de.hochschule.augsburg.registrationWindow.infrastructure.entity.RegistrationWindowEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RegistrationWindowMapper {
    RegistrationWindowEntity map(RegistrationWindow registrationWindow);

    RegistrationWindow map(RegistrationWindowEntity registrationPeriod);

    List<RegistrationWindow> map(List<RegistrationWindowEntity> entityList);
}
