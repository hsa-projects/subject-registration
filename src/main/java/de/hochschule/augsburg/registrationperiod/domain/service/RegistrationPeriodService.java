package de.hochschule.augsburg.registrationperiod.domain.service;

import de.hochschule.augsburg.registrationperiod.domain.mapper.RegistrationPeriodMapper;
import de.hochschule.augsburg.registrationperiod.domain.model.RegistrationPeriod;
import de.hochschule.augsburg.registrationperiod.domain.model.RegistrationPeriodUpdate;
import de.hochschule.augsburg.registrationperiod.infrastructure.entity.RegistrationPeriodEntity;
import de.hochschule.augsburg.registrationperiod.infrastructure.repository.RegistrationPeriodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to handle registration periods.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RegistrationPeriodService {
    private final RegistrationPeriodRepository registrationPeriodRepository;
    private final RegistrationPeriodMapper registrationPeriodMapper;
    private final RuntimeService runtimeService;

    /**
     * Get all registration periods.
     *
     * @return registration periods
     */
    public List<RegistrationPeriod> getAllRegistrationPeriods() {
        return this.registrationPeriodMapper.map(this.registrationPeriodRepository.findAll());
    }

    /**
     * Create a new Registration Period.
     *
     * @param newRegistrationPeriod Registration period that is created
     * @param professor         Professor that starts the new registration period
     * @return the new registration
     */
    public RegistrationPeriod createRegistrationPeriod(final RegistrationPeriod newRegistrationPeriod, final String professor) {

        //TODO only professor with granted access can create registration period


        //TODO start a process
//        runtimeService.startProcessInstanceByKey("MeinTollerProzess");

        return this.saveRegistrationPeriod(newRegistrationPeriod);
    }

    /**
     * Update an existing registration period.
     *
     * @param registrationPeriodUpdate Update that is applieded
     * @param professor            Id of the professor
     * @return the updated registrationPeriod
     */
    public RegistrationPeriod updateRegistrationPeriod(final RegistrationPeriodUpdate registrationPeriodUpdate, final String professor) {
        final RegistrationPeriod registrationPeriod = this.getRegistrationPeriod(registrationPeriodUpdate.getId());

        // TODO is the registrationPeriod of the professor with granted access?

        registrationPeriod.update(registrationPeriodUpdate);
        return this.saveRegistrationPeriod(registrationPeriod);
    }

    /**
     * Delete an existing registration period
     * @param registrationPeriodId
     * @param professor
     */
    public void deleteRegistrationPeriod(final String registrationPeriodId, final String professor) {
        final RegistrationPeriod registrationPeriod = this.getRegistrationPeriod(registrationPeriodId);

        // TODO is the registrationPeriod of the professor with granted access?

        this.registrationPeriodRepository.deleteById(registrationPeriod.getId());
    }

    // Helper Methods

    private RegistrationPeriod saveRegistrationPeriod(final RegistrationPeriod registrationPeriod) {
        final RegistrationPeriodEntity savedRegistrationPeriod = this.registrationPeriodRepository.save(this.registrationPeriodMapper.map(registrationPeriod));
        return this.registrationPeriodMapper.map(savedRegistrationPeriod);
    }

    private RegistrationPeriod getRegistrationPeriod(final String registrationPeriodId) {
        return this.registrationPeriodRepository.findById(registrationPeriodId)
                .map(this.registrationPeriodMapper::map)
                .orElseThrow();
    }

}
