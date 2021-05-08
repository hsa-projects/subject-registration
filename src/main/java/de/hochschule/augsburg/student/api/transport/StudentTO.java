package de.hochschule.augsburg.student.api.transport;

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
@Schema(description = "Information to a specific student")
public class StudentTO {
    @NotBlank
    private String id;

    @NotBlank
    private int matrikelNummer;

    @NotBlank
    private String name;
}
