package de.hochschule.augsburg.registrationwindow.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RegistrationWindow {
    private final String id;

    private final String semester;

    private String startDate;

    private String endDate;

    public void update(final RegistrationWindowUpdate update) {
        this.startDate = update.getStartDate();
        this.endDate = update.getEndDate();
    }
}
