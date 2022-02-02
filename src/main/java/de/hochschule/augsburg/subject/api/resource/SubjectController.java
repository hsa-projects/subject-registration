package de.hochschule.augsburg.subject.api.resource;

import de.hochschule.augsburg.subject.api.mapper.SubjectApiMapper;
import de.hochschule.augsburg.subject.api.transport.SubjectUpdateTO;
import de.hochschule.augsburg.subject.api.transport.NewSubjectTO;
import de.hochschule.augsburg.subject.api.transport.SubjectTO;
import de.hochschule.augsburg.subject.domain.model.Subject;
import de.hochschule.augsburg.subject.domain.service.SubjectService;
import de.hochschule.augsburg.security.UserContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Slf4j
@Validated
@CrossOrigin
@RestController
@RequiredArgsConstructor
@Tag(name = "Subject Controller")
@RequestMapping("/api/subject")
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectApiMapper subjectApiMapper;
    private final UserContext userContext;

    @GetMapping
    @PreAuthorize("@securityService.admin or @securityService.professor or @securityService.student")
    @Transactional(readOnly = true)
    @Operation(summary = "Get list of all Subjects")
    public ResponseEntity<List<SubjectTO>> getAllSubjects() {

        userContext.getLoggedInUser();

        log.debug("Received request to get all subjects");
        final List<Subject> subjects = this.subjectService.getAllSubjects();
        return ResponseEntity.ok(this.subjectApiMapper.map(subjects));
    }

    @Transactional
    @PutMapping()
    @PreAuthorize("@securityService.admin or @securityService.professor")
    @Operation(summary = "Update an existing subject")
    public ResponseEntity<SubjectTO> updateSubject(
            @RequestBody @Valid final SubjectUpdateTO updateTO
    ) {
        log.debug("Received request to update the registration with the id '{}'", updateTO.getId());
        final Subject subject = this.subjectService.updateSubject(this.subjectApiMapper.map(updateTO), this.userContext.getLoggedInUser());
        return ResponseEntity.ok(this.subjectApiMapper.map(subject));
    }

    @PostMapping
    @PreAuthorize("@securityService.admin or @securityService.professor")
    @Transactional
    @Operation(summary = "Create a new subject")
    public ResponseEntity<SubjectTO> createSubject(@RequestBody @Valid final NewSubjectTO newSubjectTO) {
        final Subject createdSubject = this.subjectService.createSubject(this.subjectApiMapper.map(newSubjectTO), this.userContext.getLoggedInUser());
        return ResponseEntity.ok(this.subjectApiMapper.map(createdSubject));
    }

    @Transactional
    @PreAuthorize("@securityService.admin or @securityService.professor")
    @DeleteMapping("/{subjectId}")
    @Operation(summary = "Delete an existing subject")
    public ResponseEntity<Void> deleteSubject(@PathVariable("subjectId") final String subjectId) {
        log.debug("Received request to delete the subject with the id '{}'", subjectId);
        this.subjectService.deleteSubject(UUID.fromString(subjectId), this.userContext.getLoggedInUser());
        return ResponseEntity.ok().build();
    }
}