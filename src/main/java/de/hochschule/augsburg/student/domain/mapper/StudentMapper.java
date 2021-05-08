package de.hochschule.augsburg.student.domain.mapper;

import de.hochschule.augsburg.student.domain.model.Student;
import de.hochschule.augsburg.student.infrastructure.entity.StudentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentEntity map(Student student);

    Student map(StudentEntity studentEntity);

    List<Student> map(List<StudentEntity> list);
}
