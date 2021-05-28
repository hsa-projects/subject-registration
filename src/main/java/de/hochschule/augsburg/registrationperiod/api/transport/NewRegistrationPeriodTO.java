package de.hochschule.augsburg.registrationperiod.api.transport;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Information to a new registration period")
public class NewRegistrationPeriodTO {
    @NotNull
    @NotBlank
    private String semester;

    @NotNull
    @NotBlank
    private String startDate;

    @NotNull
    @NotBlank
    private String duration;
}
