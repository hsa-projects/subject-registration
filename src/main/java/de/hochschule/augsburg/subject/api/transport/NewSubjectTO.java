package de.hochschule.augsburg.subject.api.transport;

import camundajar.impl.scala.Predef;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data to create a new subject")
public class NewSubjectTO {

    @NotBlank
    private String name;

    @NotBlank
    private String professor;

    @NotBlank
    private String creditPoints;

    private String description;

    private String specialization;

}
