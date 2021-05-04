package de.hochschule.augsburg.registration.domain.mapper;

import de.hochschule.augsburg.registration.domain.model.Registration;
import de.hochschule.augsburg.registration.domain.model.Registration.RegistrationBuilder;
import de.hochschule.augsburg.registration.domain.model.SubjectSelection;
import de.hochschule.augsburg.registration.domain.model.SubjectSelection.SubjectSelectionBuilder;
import de.hochschule.augsburg.registration.infrastructure.entity.RegistrationEntity;
import de.hochschule.augsburg.registration.infrastructure.entity.RegistrationEntity.RegistrationEntityBuilder;
import de.hochschule.augsburg.registration.infrastructure.entity.SubjectSelectionEntity;
import de.hochschule.augsburg.registration.infrastructure.entity.SubjectSelectionEntity.SubjectSelectionEntityBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15 (AdoptOpenJDK)"
)
@Component
public class RegistrationMapperImpl implements RegistrationMapper {

    @Override
    public RegistrationEntity map(Registration registration) {
        if ( registration == null ) {
            return null;
        }

        RegistrationEntityBuilder registrationEntity = RegistrationEntity.builder();

        registrationEntity.id( registration.getId() );
        registrationEntity.student( registration.getStudent() );
        registrationEntity.subjectSelection( subjectSelectionListToSubjectSelectionEntityList( registration.getSubjectSelection() ) );

        return registrationEntity.build();
    }

    @Override
    public List<Registration> map(List<RegistrationEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<Registration> list = new ArrayList<Registration>( entityList.size() );
        for ( RegistrationEntity registrationEntity : entityList ) {
            list.add( map( registrationEntity ) );
        }

        return list;
    }

    @Override
    public Registration map(RegistrationEntity registration) {
        if ( registration == null ) {
            return null;
        }

        RegistrationBuilder registration1 = Registration.builder();

        registration1.id( registration.getId() );
        registration1.student( registration.getStudent() );
        registration1.subjectSelection( subjectSelectionEntityListToSubjectSelectionList( registration.getSubjectSelection() ) );

        return registration1.build();
    }

    protected SubjectSelectionEntity subjectSelectionToSubjectSelectionEntity(SubjectSelection subjectSelection) {
        if ( subjectSelection == null ) {
            return null;
        }

        SubjectSelectionEntityBuilder subjectSelectionEntity = SubjectSelectionEntity.builder();

        subjectSelectionEntity.id( subjectSelection.getId() );
        subjectSelectionEntity.subject( subjectSelection.getSubject() );
        subjectSelectionEntity.points( subjectSelection.getPoints() );

        return subjectSelectionEntity.build();
    }

    protected List<SubjectSelectionEntity> subjectSelectionListToSubjectSelectionEntityList(List<SubjectSelection> list) {
        if ( list == null ) {
            return null;
        }

        List<SubjectSelectionEntity> list1 = new ArrayList<SubjectSelectionEntity>( list.size() );
        for ( SubjectSelection subjectSelection : list ) {
            list1.add( subjectSelectionToSubjectSelectionEntity( subjectSelection ) );
        }

        return list1;
    }

    protected SubjectSelection subjectSelectionEntityToSubjectSelection(SubjectSelectionEntity subjectSelectionEntity) {
        if ( subjectSelectionEntity == null ) {
            return null;
        }

        SubjectSelectionBuilder subjectSelection = SubjectSelection.builder();

        subjectSelection.id( subjectSelectionEntity.getId() );
        subjectSelection.subject( subjectSelectionEntity.getSubject() );
        subjectSelection.points( subjectSelectionEntity.getPoints() );

        return subjectSelection.build();
    }

    protected List<SubjectSelection> subjectSelectionEntityListToSubjectSelectionList(List<SubjectSelectionEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SubjectSelection> list1 = new ArrayList<SubjectSelection>( list.size() );
        for ( SubjectSelectionEntity subjectSelectionEntity : list ) {
            list1.add( subjectSelectionEntityToSubjectSelection( subjectSelectionEntity ) );
        }

        return list1;
    }
}
