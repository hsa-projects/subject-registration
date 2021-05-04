package de.hochschule.augsburg.subject.api.resource;

import de.hochschule.augsburg.subject.api.mapper.SubjectApiMapper;
import de.hochschule.augsburg.subject.api.transport.NewSubjectTO;
import de.hochschule.augsburg.subject.api.transport.SubjectTO;
import de.hochschule.augsburg.subject.domain.model.Subject;
import de.hochschule.augsburg.subject.domain.service.SubjectService;
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
@Tag(name = "Subject Controller")
@RequestMapping("/api/subject")
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectApiMapper subjectApiMapper;

    @GetMapping
    @Transactional(readOnly = true)
    @Operation(summary = "Get list of all Subjects")
    public ResponseEntity<List<SubjectTO>> getAllSubject() {
        log.debug("Received request to get all subjects");
        final List<Subject> subjects = this.subjectService.getAllSubject();
        return ResponseEntity.ok(this.subjectApiMapper.map(subjects));
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Create a new subject")
    public ResponseEntity<SubjectTO> createSubject(@RequestBody @Valid final NewSubjectTO newSubjectTO) {
        final Subject createdSubject = this.subjectService.createSubject(this.subjectApiMapper.map(newSubjectTO));
        return ResponseEntity.ok(this.subjectApiMapper.map(createdSubject));
    }

}
