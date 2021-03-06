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
@Schema(description = "Data to update a subject")
public class SubjectUpdateTO {
    @NotNull
    private UUID id;

    @NotBlank
    @NotNull
    private String professor;

    @NotNull
    private Integer creditPoints;

    private String description;

    private String specialization;
}