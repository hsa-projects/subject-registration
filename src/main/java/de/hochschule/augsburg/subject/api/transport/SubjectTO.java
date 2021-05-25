package de.hochschule.augsburg.subject.api.transport;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Information to a specific subject")
public class SubjectTO {

    @NotBlank
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String professor;

    @NotBlank
    private Byte creditPoints;

    private String description;

    private String specialization;

}
