package de.hochschule.augsburg.student.domain.service;

import de.hochschule.augsburg.student.domain.mapper.StudentMapper;
import de.hochschule.augsburg.student.domain.model.Student;
import de.hochschule.augsburg.student.infrastructure.entity.StudentEntity;
import de.hochschule.augsburg.student.infrastructure.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<Student> getAllStudent() {
        return this.studentMapper.map(this.studentRepository.findAll());
    }

    public Student createStudent(final Student student) {
        final StudentEntity savedStudent = this.studentRepository.save(this.studentMapper.map(student));
        return this.studentMapper.map(savedStudent);
    }
}
