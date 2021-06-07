package de.hochschule.augsburg.registrationwindow.api.transport;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data to update a registration period")
public class RegistrationWindowUpdateTO {
    @NotNull
    @NotBlank
    private String id;

    @NotNull
    @NotBlank
    private String startDate;

    @NotNull
    @NotBlank
    private String endDate;
}
