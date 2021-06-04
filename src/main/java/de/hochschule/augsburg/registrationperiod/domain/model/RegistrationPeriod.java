package de.hochschule.augsburg.registrationperiod.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RegistrationPeriod {
    private final String id;

    private final String semester;

    private String startDate;

    private String endDate;

    public void update(final RegistrationPeriodUpdate update) {
        this.startDate = update.getStartDate();
        this.endDate = update.getEndDate();
    }
}
