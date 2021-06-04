package de.hochschule.augsburg.registrationperiod.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RegistrationPeriodUpdate {
    private final String id;

    private final String startDate;

    private final String endDate;
}
