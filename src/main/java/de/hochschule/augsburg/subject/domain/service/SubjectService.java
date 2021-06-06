package de.hochschule.augsburg.subject.domain.service;

import de.hochschule.augsburg.subject.domain.mapper.SubjectMapper;
import de.hochschule.augsburg.subject.domain.model.Subject;
import de.hochschule.augsburg.subject.domain.model.SubjectUpdate;
import de.hochschule.augsburg.subject.infrastructure.entity.SubjectEntity;
import de.hochschule.augsburg.subject.infrastructure.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    //TODO Check ob das Frontend Filter übernimmt
    /**
     * Get all subjects by professor
     * @param professor Name of professor
     * @return subjects
     */
    public List<Subject> getSubjectsByProfessor(final String professor){
        return this.subjectMapper.map(this.subjectRepository.findAllByProfessor(professor));
    }

    //TODO Check ob das Frontend Filter übernimmt
    /**
     * Get all subjects by specialization
     * @param specialization Specialization of subject
     * @return subjects
     */
    public  List<Subject> getSubjectsBySpecialization(final String specialization){
        return this.subjectMapper.map(this.subjectRepository.findAllBySpecialization(specialization));
    }

    //TODO Check ob das Frontend Filter übernimmt
    /**
     * Get all subjects by credit points
     * @param creditPoints CreditPoints
     * @return subjects
     */
    public List<Subject> getSubjectsByCreditPoints(final Float creditPoints) {
        return this.subjectMapper.map(this.subjectRepository.findAllByCreditPoints(creditPoints));
    }

    /**
     * Create a new subject
     *
     * @param newSubject subject that is created
     * @param professor Professor that gets assigned to the new subject
     *
     * @return the new subject
     */
    public Subject createSubject(final Subject newSubject, final String professor) {
        newSubject.assignProfessor(professor);

        return this.saveSubject(newSubject);
    }

    /**
     * Delete subject
     *
     * @param subjectName Name of subject
     */
    public void deleteSubject(final String subjectName, final String professor) {
        final Subject subject = this.subjectMapper.map(this.subjectRepository.findByName(subjectName));

        //is the subject of the given professor?
        if (!subject.getProfessor().equals(professor)) {
            throw new RuntimeException("Subject is not available for delete");
        }

        this.subjectRepository.deleteSubjectByName(subjectName);
    }

    /**
     * Update an existing subject.
     *
     * @param subjectUpdate Update that is applieded
     * @param professor            Id of the professor
     * @return the updated subject
     */
    public Subject updateSubject(final SubjectUpdate subjectUpdate, final String professor) {

        final Subject subject = this.getSubject(subjectUpdate.getId());

        // TODO Update of subject should be also available for administrator

        //is the subject of the given professor?
        if (!subject.getProfessor().equals(professor)) {
            throw new RuntimeException("Subject is not available for update");
        }

        subject.update(subjectUpdate);
        return this.saveSubject(subject);
    }


    // Helper Methods

    private Subject saveSubject(final Subject subject) {
        final SubjectEntity savedSubject = this.subjectRepository.save(this.subjectMapper.map(subject));
        return this.subjectMapper.map(savedSubject);
    }

    private Subject getSubject(final UUID subjectId) {
        return this.subjectRepository.findById(subjectId)
                .map(this.subjectMapper::map)
                .orElseThrow();
    }
}