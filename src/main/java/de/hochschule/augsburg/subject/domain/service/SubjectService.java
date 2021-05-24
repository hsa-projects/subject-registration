package de.hochschule.augsburg.subject.domain.service;

import de.hochschule.augsburg.registration.domain.model.Registration;
import de.hochschule.augsburg.subject.domain.mapper.SubjectMapper;
import de.hochschule.augsburg.subject.domain.model.Subject;
import de.hochschule.augsburg.subject.infrastructure.entity.SubjectEntity;
import de.hochschule.augsburg.subject.infrastructure.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    /**
     * Get all subjects.
     *
     * @return subjects
     */
    public List<Subject> getAllSubjects() {
        return this.subjectMapper.map(this.subjectRepository.findAll());
    }

    /**
     * Get all subjects by professor
     * @param professor Name of professor
     * @return subjects
     */
    public List<Subject> getSubjectsbyProfessor(final String professor){
        return this.subjectMapper.map(this.subjectRepository.findAllByProfessor(professor));
    }

    /**
     * Get all subjects by specialization
     * @param specialization Specialization of subject
     * @return subjects
     */
    public  List<Subject> getSubjectsBySpecialization(final String specialization){
        return this.subjectMapper.map(this.subjectRepository.findAllBySpecialization(specialization));
    }

    /**
     * Get all subjects by credit points
     * @param creditPoints CreditPoints
     * @return subjects
     */
    public List<Subject> getSubjectsByCreditPoints(final Byte creditPoints) {
        return this.subjectMapper.map(this.subjectRepository.findAllByCreditPoints(creditPoints));
    }

    /**
     * Create a new subject
     * @param subject subject that is created
     * @return the new subject
     */
    public Subject createSubject(final Subject subject) {
        final SubjectEntity savedSubject = this.subjectRepository.save(this.subjectMapper.map(subject));
        return this.subjectMapper.map(savedSubject);
    }

    /**
     * Delete subject
     *
     * @param subjectName Name of subject
     */
    public void deleteSubject(final String subjectName) {
        this.subjectRepository.deleteSubjectByName(subjectName);
    }

    // Helper Methods

    private Subject saveSubject(final Subject subject) {
        final SubjectEntity savedSubject = this.subjectRepository.save(this.subjectMapper.map(subject));
        return this.subjectMapper.map(savedSubject);
    }

    private Subject getSubject(final String subjectId) {
        return this.subjectRepository.findById(subjectId)
                .map(this.subjectMapper::map)
                .orElseThrow();
    }

    private Subject getSubjectByName(final String subjectName) {
        return this.subjectRepository.findById(subjectName)
                .map(this.subjectMapper::map)
                .orElseThrow();
    }
}
