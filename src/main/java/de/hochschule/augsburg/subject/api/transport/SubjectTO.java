package de.hochschule.augsburg.subject.api.transport;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Information to a specific subject")
public class SubjectTO {

    @NotBlank
    @NotNull
    private String id;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String professor;

    @NotBlank
    @NotNull
    private Integer creditPoints;

    private String description;

    private String specialization;

}
