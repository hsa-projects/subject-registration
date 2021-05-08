package de.hochschule.augsburg.student.api.mapper;

import de.hochschule.augsburg.student.api.transport.NewStudentTO;
import de.hochschule.augsburg.student.api.transport.StudentTO;
import de.hochschule.augsburg.student.domain.model.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface StudentApiMapper {
    Student map(NewStudentTO newStudentTO);

    StudentTO map(Student student);

    List<StudentTO> map(List<Student> list);
}
