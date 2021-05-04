package de.hochschule.augsburg.subject.api.mapper;

import de.hochschule.augsburg.subject.api.transport.NewSubjectTO;
import de.hochschule.augsburg.subject.api.transport.SubjectTO;
import de.hochschule.augsburg.subject.domain.model.Subject;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SubjectApiMapper {

    Subject map(NewSubjectTO newSubjectTO);

    SubjectTO map(Subject subject);

    List<SubjectTO> map(List<Subject> list);

}
