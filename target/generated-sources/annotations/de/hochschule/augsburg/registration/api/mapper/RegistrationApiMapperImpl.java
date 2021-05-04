package de.hochschule.augsburg.registration.api.mapper;

import de.hochschule.augsburg.registration.api.transport.NewRegistrationTO;
import de.hochschule.augsburg.registration.api.transport.NewSubjectSelectionTO;
import de.hochschule.augsburg.registration.api.transport.RegistrationTO;
import de.hochschule.augsburg.registration.api.transport.RegistrationTO.RegistrationTOBuilder;
import de.hochschule.augsburg.registration.api.transport.RegistrationUpdateTO;
import de.hochschule.augsburg.registration.api.transport.SubjectSelectionTO;
import de.hochschule.augsburg.registration.api.transport.SubjectSelectionTO.SubjectSelectionTOBuilder;
import de.hochschule.augsburg.registration.domain.model.Registration;
import de.hochschule.augsburg.registration.domain.model.Registration.RegistrationBuilder;
import de.hochschule.augsburg.registration.domain.model.RegistrationUpdate;
import de.hochschule.augsburg.registration.domain.model.RegistrationUpdate.RegistrationUpdateBuilder;
import de.hochschule.augsburg.registration.domain.model.SubjectSelection;
import de.hochschule.augsburg.registration.domain.model.SubjectSelection.SubjectSelectionBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15 (AdoptOpenJDK)"
)
@Component
public class RegistrationApiMapperImpl implements RegistrationApiMapper {

    @Override
    public List<RegistrationTO> map(List<Registration> registrations) {
        if ( registrations == null ) {
            return null;
        }

        List<RegistrationTO> list = new ArrayList<RegistrationTO>( registrations.size() );
        for ( Registration registration : registrations ) {
            list.add( map( registration ) );
        }

        return list;
    }

    @Override
    public Registration map(NewRegistrationTO newRegistration) {
        if ( newRegistration == null ) {
            return null;
        }

        RegistrationBuilder registration = Registration.builder();

        registration.subjectSelection( newSubjectSelectionTOListToSubjectSelectionList( newRegistration.getSubjectSelection() ) );

        return registration.build();
    }

    @Override
    public RegistrationUpdate map(RegistrationUpdateTO update) {
        if ( update == null ) {
            return null;
        }

        RegistrationUpdateBuilder registrationUpdate = RegistrationUpdate.builder();

        registrationUpdate.id( update.getId() );

        return registrationUpdate.build();
    }

    @Override
    public RegistrationTO map(Registration registration) {
        if ( registration == null ) {
            return null;
        }

        RegistrationTOBuilder registrationTO = RegistrationTO.builder();

        registrationTO.id( registration.getId() );
        registrationTO.student( registration.getStudent() );
        registrationTO.subjectSelection( subjectSelectionListToSubjectSelectionTOList( registration.getSubjectSelection() ) );

        return registrationTO.build();
    }

    protected SubjectSelection newSubjectSelectionTOToSubjectSelection(NewSubjectSelectionTO newSubjectSelectionTO) {
        if ( newSubjectSelectionTO == null ) {
            return null;
        }

        SubjectSelectionBuilder subjectSelection = SubjectSelection.builder();

        subjectSelection.subject( newSubjectSelectionTO.getSubject() );
        subjectSelection.points( newSubjectSelectionTO.getPoints() );

        return subjectSelection.build();
    }

    protected List<SubjectSelection> newSubjectSelectionTOListToSubjectSelectionList(List<NewSubjectSelectionTO> list) {
        if ( list == null ) {
            return null;
        }

        List<SubjectSelection> list1 = new ArrayList<SubjectSelection>( list.size() );
        for ( NewSubjectSelectionTO newSubjectSelectionTO : list ) {
            list1.add( newSubjectSelectionTOToSubjectSelection( newSubjectSelectionTO ) );
        }

        return list1;
    }

    protected SubjectSelectionTO subjectSelectionToSubjectSelectionTO(SubjectSelection subjectSelection) {
        if ( subjectSelection == null ) {
            return null;
        }

        SubjectSelectionTOBuilder subjectSelectionTO = SubjectSelectionTO.builder();

        subjectSelectionTO.id( subjectSelection.getId() );
        subjectSelectionTO.subject( subjectSelection.getSubject() );
        subjectSelectionTO.points( subjectSelection.getPoints() );

        return subjectSelectionTO.build();
    }

    protected List<SubjectSelectionTO> subjectSelectionListToSubjectSelectionTOList(List<SubjectSelection> list) {
        if ( list == null ) {
            return null;
        }

        List<SubjectSelectionTO> list1 = new ArrayList<SubjectSelectionTO>( list.size() );
        for ( SubjectSelection subjectSelection : list ) {
            list1.add( subjectSelectionToSubjectSelectionTO( subjectSelection ) );
        }

        return list1;
    }
}
