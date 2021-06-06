package de.hochschule.augsburg.registration.domain.process;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.camunda.bpm.engine.impl.calendar.DateTimeUtil;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Getter
public class RegistrationProcessVariables {
    private Date registration_window_start = DateTimeUtil.parseDate("2021-11-20T10:02:00");
    private Date registration_window_end = DateTimeUtil.parseDate("2021-11-20T10:02:00");

}
