package de.hochschule.augsburg.registrationwindow.domain.service;

import de.hochschule.augsburg.registrationwindow.domain.mapper.RegistrationWindowMapper;
import de.hochschule.augsburg.registrationwindow.domain.model.RegistrationWindow;
import de.hochschule.augsburg.registrationwindow.domain.model.RegistrationWindowUpdate;
import de.hochschule.augsburg.registrationwindow.infrastructure.entity.RegistrationWindowEntity;
import de.hochschule.augsburg.registrationwindow.infrastructure.repository.RegistrationWindowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to handle registration periods.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RegistrationWindowService {
    private final RegistrationWindowRepository registrationWindowRepository;
    private final RegistrationWindowMapper registrationWindowMapper;
    private final RuntimeService runtimeService;

    /**
     * Get all registration periods.
     *
     * @return registration periods
     */
    public List<RegistrationWindow> getAllRegistrationPeriods() {
        return this.registrationWindowMapper.map(this.registrationWindowRepository.findAll());
    }

    /**
     * Create a new Registration Period.
     *
     * @param newRegistrationWindow Registration period that is created
     * @param professor         Professor that starts the new registration period
     * @return the new registration
     */
    public RegistrationWindow createRegistrationPeriod(final RegistrationWindow newRegistrationWindow, final String professor) {

        //TODO only professor with granted access can create registration period

        VariableMap variables = Variables.createVariables();

        //TODO start a process
//        runtimeService.startProcessInstanceByKey("MeinTollerProzess");
        final RegistrationWindow savedRegistrationWindow = this.saveRegistrationPeriod(newRegistrationWindow);

        this.runtimeService.startProcessInstanceByKey("Process_Registration_Window", savedRegistrationWindow.getId(), variables);

        return savedRegistrationWindow;
    }

    /**
     * Update an existing registration period.
     *
     * @param registrationWindowUpdate Update that is applieded
     * @param professor            Id of the professor
     * @return the updated registrationPeriod
     */
    public RegistrationWindow updateRegistrationPeriod(final RegistrationWindowUpdate registrationWindowUpdate, final String professor) {
        final RegistrationWindow registrationWindow = this.getRegistrationPeriod(registrationWindowUpdate.getId());

        // TODO is the registrationPeriod of the professor with granted access?

        registrationWindow.update(registrationWindowUpdate);
        return this.saveRegistrationPeriod(registrationWindow);
    }

    /**
     * Delete an existing registration period
     * @param registrationPeriodId
     * @param professor
     */
    public void deleteRegistrationPeriod(final String registrationPeriodId, final String professor) {
        final RegistrationWindow registrationWindow = this.getRegistrationPeriod(registrationPeriodId);

        // TODO is the registrationPeriod of the professor with granted access?

        this.registrationWindowRepository.deleteById(registrationWindow.getId());
    }

    // Helper Methods

    private RegistrationWindow saveRegistrationPeriod(final RegistrationWindow registrationWindow) {
        final RegistrationWindowEntity savedRegistrationPeriod = this.registrationWindowRepository.save(this.registrationWindowMapper.map(registrationWindow));
        return this.registrationWindowMapper.map(savedRegistrationPeriod);
    }

    private RegistrationWindow getRegistrationPeriod(final String registrationPeriodId) {
        return this.registrationWindowRepository.findById(registrationPeriodId)
                .map(this.registrationWindowMapper::map)
                .orElseThrow();
    }

}
