package de.hochschule.augsburg.registration.api.transport;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data to update a registration")
public class RegistrationUpdateTO {

    @NotNull
    @NotBlank
    private String id;

    @NotNull
    @Size(min = 1)
    private List<SubjectSelectionTO> subjectSelection;

}
