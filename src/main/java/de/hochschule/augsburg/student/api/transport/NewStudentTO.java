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
@Schema(description = "Data to create a new student")
public class NewStudentTO {
    @NotBlank
    private String name;

    @NotBlank
    private int matrikelNummer;
}
