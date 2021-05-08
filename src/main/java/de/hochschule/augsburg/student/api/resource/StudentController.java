package de.hochschule.augsburg.student.api.resource;

import de.hochschule.augsburg.student.api.mapper.StudentApiMapper;
import de.hochschule.augsburg.student.api.transport.NewStudentTO;
import de.hochschule.augsburg.student.api.transport.StudentTO;
import de.hochschule.augsburg.student.domain.model.Student;
import de.hochschule.augsburg.student.domain.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@Tag(name = "Student Controller")
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;
    private final StudentApiMapper studentApiMapper;

    @GetMapping
    @Transactional(readOnly = true)
    @Operation(summary = "Get list of all students")
    public ResponseEntity<List<StudentTO>> getAllSubject() {
        log.debug("Received request to get all subjects");
        final List<Student> students = this.studentService.getAllStudent();
        return ResponseEntity.ok(this.studentApiMapper.map(students));
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Create a new student")
    public ResponseEntity<StudentTO> createStudent(@RequestBody @Valid final NewStudentTO newStudentTO) {
        final Student createdStudent = this.studentService.createStudent(this.studentApiMapper.map(newStudentTO));
        return ResponseEntity.ok(this.studentApiMapper.map(createdStudent));
    }
}
