package de.hochschule.augsburg.subject.domain.mapper;

import de.hochschule.augsburg.subject.domain.model.Subject;
import de.hochschule.augsburg.subject.infrastructure.entity.SubjectEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Mapper
public interface SubjectMapper {

    SubjectEntity map(Subject subject);

    Subject map(SubjectEntity subjectEntity);

    List<Subject> map(List<SubjectEntity> subjectList);
}