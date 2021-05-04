package de.hochschule.augsburg.registration.api.transport;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Information to a specific registration")
public class RegistrationTO {

    @NotNull
    @NotBlank
    private String id;

    @NotNull
    @NotBlank
    private String student;

    @NotNull
    @Size(min = 1)
    private List<SubjectSelectionTO> subjectSelection;

}
