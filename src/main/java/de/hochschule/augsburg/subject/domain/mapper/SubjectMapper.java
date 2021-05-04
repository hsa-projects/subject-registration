package de.hochschule.augsburg.subject.domain.mapper;

import de.hochschule.augsburg.subject.domain.model.Subject;
import de.hochschule.augsburg.subject.infrastructure.SubjectEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SubjectMapper {

    SubjectEntity map(Subject subject);

    Subject map(SubjectEntity subjectEntity);

    List<Subject> map(List<SubjectEntity> list);

}
