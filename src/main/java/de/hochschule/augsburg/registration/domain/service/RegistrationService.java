package de.hochschule.augsburg.registration.domain.service;

import de.hochschule.augsburg.registration.domain.mapper.RegistrationMapper;
import de.hochschule.augsburg.registration.domain.model.Registration;
import de.hochschule.augsburg.registration.domain.model.RegistrationUpdate;
import de.hochschule.augsburg.registration.infrastructure.entity.RegistrationEntity;
import de.hochschule.augsburg.registration.infrastructure.repository.RegistrationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to handle registrations.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final RegistrationMapper registrationMapper;

    /**
     * Get all registrations.
     *
     * @return registrations
     */
    public List<Registration> getAllRegistrations() {
        return this.registrationMapper.map(this.registrationRepository.findAll());
    }

    /**
     * Get all registrations by student.
     *
     * @param student Id of the student
     * @return registrations
     */
    public List<Registration> getRegistrationsByStudent(final String student) {
        return this.registrationMapper.map(this.registrationRepository.findAllByStudent(student));
    }

    /**
     * Create a new Registration.
     *
     * @param newRegistration Registration that is created
     * @param student         Student that gets assigned to the new registration
     * @return the new registration
     */
    public Registration createRegistration(final Registration newRegistration, final String student) {

        //TODO student can only start one registration?


        //TODO start a process

        newRegistration.assignStudent(student);
        return this.saveRegistration(newRegistration);
    }

    /**
     * Update an existing registration.
     *
     * @param registrationUpdate Update that is applieded
     * @param student            Id of the student
     * @return the updated registration
     */
    public Registration updateRegistration(final RegistrationUpdate registrationUpdate, final String student) {
        final Registration registration = this.getRegistration(registrationUpdate.getId());

        //is the registration of the given student?
        if (!registration.getStudent().equals(student)) {
            throw new RuntimeException("Registration not available");
        }

        registration.update(registrationUpdate);
        return this.saveRegistration(registration);
    }


    public void deleteRegistration(final String registrationId, final String student) {
        final Registration registration = this.getRegistration(registrationId);

        //is the registration of the given student?
        if (!registration.getStudent().equals(student)) {
            throw new RuntimeException("Registration not available");
        }

        this.registrationRepository.deleteById(registration.getId());
    }

    // Helper Methods

    private Registration saveRegistration(final Registration registration) {
        final RegistrationEntity savedRegistration = this.registrationRepository.save(this.registrationMapper.map(registration));
        return this.registrationMapper.map(savedRegistration);
    }

    private Registration getRegistration(final String registrationId) {
        return this.registrationRepository.findById(registrationId)
                .map(this.registrationMapper::map)
                .orElseThrow();
    }

}
