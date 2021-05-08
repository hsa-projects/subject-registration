package de.hochschule.augsburg.student.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class Student {
    private final String id;

    private final int matrikelNummer;

    private final String name;
}
