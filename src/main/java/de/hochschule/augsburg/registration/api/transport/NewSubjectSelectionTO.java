package de.hochschule.augsburg.registration.api.transport;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data to create a new subject selection")
public class NewSubjectSelectionTO {

    @NotNull
    @NotBlank
    private String subject;

    @NotNull
    @Min(1)
    private Integer points;

}
