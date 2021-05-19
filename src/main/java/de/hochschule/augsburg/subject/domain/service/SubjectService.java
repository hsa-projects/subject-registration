package de.hochschule.augsburg.subject.domain.service;

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

    public List<Subject> getAllSubject() {
        return this.subjectMapper.map(this.subjectRepository.findAll());
    }

    public Subject createSubject(final Subject subject) {
        final SubjectEntity savedSubject = this.subjectRepository.save(this.subjectMapper.map(subject));
        return this.subjectMapper.map(savedSubject);
    }

}
