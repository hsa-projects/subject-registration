package de.hochschule.augsburg.registration.api.transport;

import de.hochschule.augsburg.subject.api.transport.SubjectTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Information to a specific subject selection")
public class SubjectSelectionTO {

    @NotNull
    private UUID id;

    @NotNull
    private RegistrationTO registration;

    @NotNull
    private SubjectTO subject;

    @NotNull
    @Min(1)
    private Integer points;

}
