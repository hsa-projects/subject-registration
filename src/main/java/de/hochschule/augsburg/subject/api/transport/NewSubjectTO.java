package de.hochschule.augsburg.subject.api.transport;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data to create a new subject")
public class NewSubjectTO {

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String professor;

    @PositiveOrZero
    @NotNull
    private Float creditPoints;

    @PositiveOrZero
    @NotNull
    private Integer capacity;

    @NotNull
    private Boolean status;

    private String description;

    private String specialization;

}