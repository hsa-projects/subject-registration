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
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data to create a new subject selection")
public class NewSubjectSelectionTO {

    @NotNull
    private UUID subject;

    @NotNull
    @Min(1)
    private Integer points;

}
