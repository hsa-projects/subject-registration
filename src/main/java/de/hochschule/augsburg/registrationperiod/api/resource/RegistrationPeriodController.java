package de.hochschule.augsburg.registrationperiod.api.resource;

import de.hochschule.augsburg.registrationperiod.api.mapper.RegistrationPeriodApiMapper;
import de.hochschule.augsburg.registrationperiod.api.transport.NewRegistrationPeriodTO;
import de.hochschule.augsburg.registrationperiod.api.transport.RegistrationPeriodTO;
import de.hochschule.augsburg.registrationperiod.api.transport.RegistrationPeriodUpdateTO;
import de.hochschule.augsburg.registrationperiod.domain.model.RegistrationPeriod;
import de.hochschule.augsburg.registrationperiod.domain.service.RegistrationPeriodService;
import de.hochschule.augsburg.security.UserContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@Tag(name = "RegistrationPeriod Controller")
@RequestMapping("/api/registration_period")
public class RegistrationPeriodController {
    private final RegistrationPeriodService registrationPeriodService;
    private final RegistrationPeriodApiMapper registrationPeriodApiMapper;
    private final UserContext userContext;

    @GetMapping
    @Transactional(readOnly = true)
    @Operation(summary = "Get list of all registration periods")
    public ResponseEntity<List<RegistrationPeriodTO>> getAllRegistrationPeriods() {
        log.debug("Received request to get all registrationPeriods");
        final List<RegistrationPeriod> allRegistrationPeriods = this.registrationPeriodService.getAllRegistrationPeriods();
        return ResponseEntity.ok().body(this.registrationPeriodApiMapper.map(allRegistrationPeriods));
    }

    @Transactional
    @PostMapping
    @Operation(summary = "Create a new registration period")
    public ResponseEntity<RegistrationPeriodTO> createNewRegistrationPeriod(@RequestBody @Valid final NewRegistrationPeriodTO newRegistrationPeriodTO) {
        log.debug("Received request to create a new registration period: {}", newRegistrationPeriodTO);
        final RegistrationPeriod registrationPeriod = this.registrationPeriodService.createRegistrationPeriod(this.registrationPeriodApiMapper.map(newRegistrationPeriodTO), this.userContext.getLoggedInUser());
        return ResponseEntity.ok(this.registrationPeriodApiMapper.map(registrationPeriod));
    }

    @Transactional
    @PutMapping()
    @Operation(summary = "Update an existing registration period")
    public ResponseEntity<RegistrationPeriodTO> updateRegistrationPeriod(
            @RequestBody @Valid final RegistrationPeriodUpdateTO updateTO
    ) {
        log.debug("Received request to update the registration with the id '{}'", updateTO.getId());
        final RegistrationPeriod registrationPeriod = this.registrationPeriodService.updateRegistrationPeriod(this.registrationPeriodApiMapper.map(updateTO), this.userContext.getLoggedInUser());
        return ResponseEntity.ok(this.registrationPeriodApiMapper.map(registrationPeriod));
    }

    @Transactional
    @DeleteMapping("/{registrationPeriodId}")
    @Operation(summary = "Delete an existing registration period")
    public ResponseEntity<Void> deleteRegistrationPeriod(@PathVariable("registrationPeriodId") final String registrationPeriodId) {
        log.debug("Received request to delete the registration period with the id '{}'", registrationPeriodId);
        this.registrationPeriodService.deleteRegistrationPeriod(registrationPeriodId, this.userContext.getLoggedInUser());
        return ResponseEntity.ok().build();
    }
}
