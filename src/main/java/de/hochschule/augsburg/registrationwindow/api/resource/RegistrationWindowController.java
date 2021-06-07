package de.hochschule.augsburg.registrationwindow.api.resource;

import de.hochschule.augsburg.registrationwindow.api.mapper.RegistrationWindowApiMapper;
import de.hochschule.augsburg.registrationwindow.api.transport.NewRegistrationWindowTO;
import de.hochschule.augsburg.registrationwindow.api.transport.RegistrationWindowTO;
import de.hochschule.augsburg.registrationwindow.api.transport.RegistrationWindowUpdateTO;
import de.hochschule.augsburg.registrationwindow.domain.model.RegistrationWindow;
import de.hochschule.augsburg.registrationwindow.domain.service.RegistrationWindowService;
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
public class RegistrationWindowController {
    private final RegistrationWindowService registrationWindowService;
    private final RegistrationWindowApiMapper registrationWindowApiMapper;
    private final UserContext userContext;

    @GetMapping
    @Transactional(readOnly = true)
    @Operation(summary = "Get list of all registration periods")
    public ResponseEntity<List<RegistrationWindowTO>> getAllRegistrationPeriods() {
        log.debug("Received request to get all registrationPeriods");
        final List<RegistrationWindow> allRegistrationWindows = this.registrationWindowService.getAllRegistrationPeriods();
        return ResponseEntity.ok().body(this.registrationWindowApiMapper.map(allRegistrationWindows));
    }

    @Transactional
    @PostMapping
    @Operation(summary = "Create a new registration period")
    public ResponseEntity<RegistrationWindowTO> createNewRegistrationPeriod(@RequestBody @Valid final NewRegistrationWindowTO newRegistrationWindowTO) {
        log.debug("Received request to create a new registration period: {}", newRegistrationWindowTO);
        final RegistrationWindow registrationWindow = this.registrationWindowService.createRegistrationPeriod(this.registrationWindowApiMapper.map(newRegistrationWindowTO), this.userContext.getLoggedInUser());
        return ResponseEntity.ok(this.registrationWindowApiMapper.map(registrationWindow));
    }

    @Transactional
    @PutMapping()
    @Operation(summary = "Update an existing registration period")
    public ResponseEntity<RegistrationWindowTO> updateRegistrationPeriod(
            @RequestBody @Valid final RegistrationWindowUpdateTO updateTO
    ) {
        log.debug("Received request to update the registration with the id '{}'", updateTO.getId());
        final RegistrationWindow registrationWindow = this.registrationWindowService.updateRegistrationPeriod(this.registrationWindowApiMapper.map(updateTO), this.userContext.getLoggedInUser());
        return ResponseEntity.ok(this.registrationWindowApiMapper.map(registrationWindow));
    }

    @Transactional
    @DeleteMapping("/{registrationPeriodId}")
    @Operation(summary = "Delete an existing registration period")
    public ResponseEntity<Void> deleteRegistrationPeriod(@PathVariable("registrationPeriodId") final String registrationPeriodId) {
        log.debug("Received request to delete the registration period with the id '{}'", registrationPeriodId);
        this.registrationWindowService.deleteRegistrationPeriod(registrationPeriodId, this.userContext.getLoggedInUser());
        return ResponseEntity.ok().build();
    }
}
