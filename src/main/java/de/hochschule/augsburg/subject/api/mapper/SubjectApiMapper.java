package de.hochschule.augsburg.subject.api.mapper;

import de.hochschule.augsburg.subject.api.transport.NewSubjectTO;
import de.hochschule.augsburg.subject.api.transport.SubjectTO;
import de.hochschule.augsburg.subject.api.transport.SubjectUpdateTO;
import de.hochschule.augsburg.subject.domain.model.Subject;
import de.hochschule.augsburg.subject.domain.model.SubjectUpdate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SubjectApiMapper {

    List<SubjectTO> map(List<Subject> subjects);

    Subject map(NewSubjectTO newSubject);

    SubjectUpdate map(SubjectUpdateTO update);

    SubjectTO map(Subject subject);

}
