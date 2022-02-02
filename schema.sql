
    create table hsa_registration (
       id BINARY(16) not null,
        semester tinyint default 1,
        student varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_registration_window (
       id varchar(36) not null,
        end_date varchar(255) not null,
        semester varchar(255) not null,
        start_date varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject (
       id BINARY(16) not null,
        capacity SMALLINT not null,
        cp DECIMAL(3,1) not null,
        description MEDIUMTEXT,
        name VARCHAR(255) not null,
        professor VARCHAR(255) not null,
        specialization VARCHAR(255),
        status BIT not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject_selection (
       id BINARY(16) not null,
        points smallint not null,
        subject_id binary(255) not null,
        registration_id BINARY(16),
        primary key (id)
    ) engine=InnoDB

    alter table hsa_subject_selection 
       add constraint FK5oo9djxl14bhig2rgv3th171x 
       foreign key (registration_id) 
       references hsa_registration (id)

    create table hsa_registration (
       id BINARY(16) not null,
        semester tinyint default 1,
        student varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_registration_window (
       id varchar(36) not null,
        end_date varchar(255) not null,
        semester varchar(255) not null,
        start_date varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject (
       id BINARY(16) not null,
        capacity SMALLINT not null,
        cp DECIMAL(3,1) not null,
        description MEDIUMTEXT,
        name VARCHAR(255) not null,
        professor VARCHAR(255) not null,
        specialization VARCHAR(255),
        status BIT not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject_selection (
       id BINARY(16) not null,
        points smallint not null,
        subject_id binary(255) not null,
        registration_id BINARY(16),
        primary key (id)
    ) engine=InnoDB

    alter table hsa_subject_selection 
       add constraint FK5oo9djxl14bhig2rgv3th171x 
       foreign key (registration_id) 
       references hsa_registration (id)

    create table hsa_registration (
       id BINARY(16) not null,
        semester tinyint default 1,
        student varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_registration_window (
       id varchar(36) not null,
        end_date varchar(255) not null,
        semester varchar(255) not null,
        start_date varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject (
       id BINARY(16) not null,
        capacity SMALLINT not null,
        cp DECIMAL(3,1) not null,
        description MEDIUMTEXT,
        name VARCHAR(255) not null,
        professor VARCHAR(255) not null,
        specialization VARCHAR(255),
        status BIT not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject_selection (
       id BINARY(16) not null,
        points smallint not null,
        subject_id binary(255) not null,
        registration_id BINARY(16),
        primary key (id)
    ) engine=InnoDB

    alter table hsa_subject_selection 
       add constraint FK5oo9djxl14bhig2rgv3th171x 
       foreign key (registration_id) 
       references hsa_registration (id)

    create table hsa_registration (
       id BINARY(16) not null,
        semester tinyint default 1,
        student varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_registration_window (
       id varchar(36) not null,
        end_date varchar(255) not null,
        semester varchar(255) not null,
        start_date varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject (
       id BINARY(16) not null,
        capacity SMALLINT not null,
        cp DECIMAL(3,1) not null,
        description MEDIUMTEXT,
        name VARCHAR(255) not null,
        professor VARCHAR(255) not null,
        specialization VARCHAR(255),
        status BIT not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject_selection (
       id BINARY(16) not null,
        points smallint not null,
        subject_id binary(255) not null,
        registration_id BINARY(16),
        primary key (id)
    ) engine=InnoDB

    alter table hsa_subject_selection 
       add constraint FK5oo9djxl14bhig2rgv3th171x 
       foreign key (registration_id) 
       references hsa_registration (id)

    create table hsa_registration (
       id BINARY(16) not null,
        semester tinyint default 1,
        student varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_registration_window (
       id varchar(36) not null,
        end_date varchar(255) not null,
        semester varchar(255) not null,
        start_date varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject (
       id BINARY(16) not null,
        capacity SMALLINT not null,
        cp DECIMAL(3,1) not null,
        description MEDIUMTEXT,
        name VARCHAR(255) not null,
        professor VARCHAR(255) not null,
        specialization VARCHAR(255),
        status BIT not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject_selection (
       id BINARY(16) not null,
        points smallint not null,
        subject_id binary(255) not null,
        registration_id BINARY(16),
        primary key (id)
    ) engine=InnoDB

    alter table hsa_subject_selection 
       add constraint FK5oo9djxl14bhig2rgv3th171x 
       foreign key (registration_id) 
       references hsa_registration (id)

    create table hsa_registration (
       id BINARY(16) not null,
        semester tinyint default 1,
        student varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_registration_window (
       id varchar(36) not null,
        end_date varchar(255) not null,
        semester varchar(255) not null,
        start_date varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject (
       id BINARY(16) not null,
        capacity SMALLINT not null,
        cp DECIMAL(3,1) not null,
        description MEDIUMTEXT,
        name VARCHAR(255) not null,
        professor VARCHAR(255) not null,
        specialization VARCHAR(255),
        status BIT not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject_selection (
       id BINARY(16) not null,
        points smallint not null,
        subject_id binary(255) not null,
        registration_id BINARY(16),
        primary key (id)
    ) engine=InnoDB

    alter table hsa_subject_selection 
       add constraint FK5oo9djxl14bhig2rgv3th171x 
       foreign key (registration_id) 
       references hsa_registration (id)

    create table hsa_registration (
       id BINARY(16) not null,
        semester tinyint default 1,
        student varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_registration_window (
       id varchar(36) not null,
        end_date varchar(255) not null,
        semester varchar(255) not null,
        start_date varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject (
       id BINARY(16) not null,
        capacity SMALLINT not null,
        cp DECIMAL(3,1) not null,
        description MEDIUMTEXT,
        name VARCHAR(255) not null,
        professor VARCHAR(255) not null,
        specialization VARCHAR(255),
        status BIT not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject_selection (
       id BINARY(16) not null,
        points smallint not null,
        subject_id binary(255) not null,
        registration_id BINARY(16),
        primary key (id)
    ) engine=InnoDB

    alter table hsa_subject_selection 
       add constraint FK5oo9djxl14bhig2rgv3th171x 
       foreign key (registration_id) 
       references hsa_registration (id)

    create table hsa_registration (
       id BINARY(16) not null,
        semester tinyint default 1,
        student varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_registration_window (
       id varchar(36) not null,
        end_date varchar(255) not null,
        semester varchar(255) not null,
        start_date varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject (
       id BINARY(16) not null,
        capacity SMALLINT not null,
        cp DECIMAL(3,1) not null,
        description MEDIUMTEXT,
        name VARCHAR(255) not null,
        professor VARCHAR(255) not null,
        specialization VARCHAR(255),
        status BIT not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject_selection (
       id BINARY(16) not null,
        points smallint not null,
        subject_id binary(255) not null,
        registration_id BINARY(16),
        primary key (id)
    ) engine=InnoDB

    alter table hsa_subject_selection 
       add constraint FK5oo9djxl14bhig2rgv3th171x 
       foreign key (registration_id) 
       references hsa_registration (id)

    create table hsa_registration (
       id BINARY(16) not null,
        semester tinyint default 1,
        student varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_registration_window (
       id varchar(36) not null,
        end_date varchar(255) not null,
        semester varchar(255) not null,
        start_date varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject (
       id BINARY(16) not null,
        capacity SMALLINT not null,
        cp DECIMAL(3,1) not null,
        description MEDIUMTEXT,
        name VARCHAR(255) not null,
        professor VARCHAR(255) not null,
        specialization VARCHAR(255),
        status BIT not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject_selection (
       id BINARY(16) not null,
        points smallint not null,
        subject_id binary(255) not null,
        registration_id BINARY(16),
        primary key (id)
    ) engine=InnoDB

    alter table hsa_subject_selection 
       add constraint FK5oo9djxl14bhig2rgv3th171x 
       foreign key (registration_id) 
       references hsa_registration (id)

    create table hsa_registration (
       id BINARY(16) not null,
        semester tinyint default 1,
        student varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_registration_window (
       id varchar(36) not null,
        end_date varchar(255) not null,
        semester varchar(255) not null,
        start_date varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject (
       id BINARY(16) not null,
        capacity SMALLINT not null,
        cp DECIMAL(3,1) not null,
        description MEDIUMTEXT,
        name VARCHAR(255) not null,
        professor VARCHAR(255) not null,
        specialization VARCHAR(255),
        status BIT not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject_selection (
       id BINARY(16) not null,
        points smallint not null,
        subject_id binary(255) not null,
        registration_id BINARY(16),
        primary key (id)
    ) engine=InnoDB

    alter table hsa_subject_selection 
       add constraint FK5oo9djxl14bhig2rgv3th171x 
       foreign key (registration_id) 
       references hsa_registration (id)

    create table hsa_registration (
       id BINARY(16) not null,
        semester tinyint default 1,
        student varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_registration_window (
       id varchar(36) not null,
        end_date varchar(255) not null,
        semester varchar(255) not null,
        start_date varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject (
       id BINARY(16) not null,
        capacity SMALLINT not null,
        cp DECIMAL(3,1) not null,
        description MEDIUMTEXT,
        name VARCHAR(255) not null,
        professor VARCHAR(255) not null,
        specialization VARCHAR(255),
        status BIT not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject_selection (
       id BINARY(16) not null,
        points smallint not null,
        subject_id binary(255) not null,
        registration_id BINARY(16),
        primary key (id)
    ) engine=InnoDB

    alter table hsa_subject_selection 
       add constraint FK5oo9djxl14bhig2rgv3th171x 
       foreign key (registration_id) 
       references hsa_registration (id)

    create table hsa_registration (
       id BINARY(16) not null,
        semester tinyint default 1,
        student varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_registration_window (
       id varchar(36) not null,
        end_date varchar(255) not null,
        semester varchar(255) not null,
        start_date varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject (
       id BINARY(16) not null,
        capacity SMALLINT not null,
        cp DECIMAL(3,1) not null,
        description MEDIUMTEXT,
        name VARCHAR(255) not null,
        professor VARCHAR(255) not null,
        specialization VARCHAR(255),
        status BIT not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject_selection (
       id BINARY(16) not null,
        points smallint not null,
        subject_id binary(255) not null,
        registration_id BINARY(16),
        primary key (id)
    ) engine=InnoDB

    alter table hsa_subject_selection 
       add constraint FK5oo9djxl14bhig2rgv3th171x 
       foreign key (registration_id) 
       references hsa_registration (id)

    create table hsa_registration (
       id BINARY(16) not null,
        semester tinyint default 1,
        student varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_registration_window (
       id varchar(36) not null,
        end_date varchar(255) not null,
        semester varchar(255) not null,
        start_date varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject (
       id BINARY(16) not null,
        capacity SMALLINT not null,
        cp DECIMAL(3,1) not null,
        description MEDIUMTEXT,
        name VARCHAR(255) not null,
        professor VARCHAR(255) not null,
        specialization VARCHAR(255),
        status BIT not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject_selection (
       id BINARY(16) not null,
        points smallint not null,
        subject_id binary(255) not null,
        registration_id BINARY(16),
        primary key (id)
    ) engine=InnoDB

    alter table hsa_subject_selection 
       add constraint FK5oo9djxl14bhig2rgv3th171x 
       foreign key (registration_id) 
       references hsa_registration (id)

    create table hsa_registration (
       id BINARY(16) not null,
        semester tinyint default 1,
        student varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_registration_window (
       id varchar(36) not null,
        end_date varchar(255) not null,
        semester varchar(255) not null,
        start_date varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject (
       id BINARY(16) not null,
        capacity SMALLINT not null,
        cp DECIMAL(3,1) not null,
        description MEDIUMTEXT,
        name VARCHAR(255) not null,
        professor VARCHAR(255) not null,
        specialization VARCHAR(255),
        status BIT not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject_selection (
       id BINARY(16) not null,
        points smallint not null,
        subject_id binary(255) not null,
        registration_id BINARY(16),
        primary key (id)
    ) engine=InnoDB

    alter table hsa_subject_selection 
       add constraint FK5oo9djxl14bhig2rgv3th171x 
       foreign key (registration_id) 
       references hsa_registration (id)

    create table hsa_registration (
       id BINARY(16) not null,
        semester tinyint default 1,
        student varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_registration_window (
       id varchar(36) not null,
        end_date varchar(255) not null,
        semester varchar(255) not null,
        start_date varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject (
       id BINARY(16) not null,
        capacity SMALLINT not null,
        cp DECIMAL(3,1) not null,
        description MEDIUMTEXT,
        name VARCHAR(255) not null,
        professor VARCHAR(255) not null,
        specialization VARCHAR(255),
        status BIT not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject_selection (
       id BINARY(16) not null,
        points smallint not null,
        subject_id binary(255) not null,
        registration_id BINARY(16),
        primary key (id)
    ) engine=InnoDB

    alter table hsa_subject_selection 
       add constraint FK5oo9djxl14bhig2rgv3th171x 
       foreign key (registration_id) 
       references hsa_registration (id)

    create table hsa_registration (
       id BINARY(16) not null,
        semester tinyint default 1,
        student varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_registration_window (
       id varchar(36) not null,
        end_date varchar(255) not null,
        semester varchar(255) not null,
        start_date varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject (
       id BINARY(16) not null,
        capacity SMALLINT not null,
        cp DECIMAL(3,1) not null,
        description MEDIUMTEXT,
        name VARCHAR(255) not null,
        professor VARCHAR(255) not null,
        specialization VARCHAR(255),
        status BIT not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject_selection (
       id BINARY(16) not null,
        points smallint not null,
        subject_id binary(255) not null,
        registration_id BINARY(16),
        primary key (id)
    ) engine=InnoDB

    alter table hsa_subject_selection 
       add constraint FK5oo9djxl14bhig2rgv3th171x 
       foreign key (registration_id) 
       references hsa_registration (id)

    create table hsa_registration (
       id BINARY(16) not null,
        semester tinyint default 1,
        student varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_registration_window (
       id varchar(36) not null,
        end_date varchar(255) not null,
        semester varchar(255) not null,
        start_date varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject (
       id BINARY(16) not null,
        capacity SMALLINT not null,
        cp DECIMAL(3,1) not null,
        description MEDIUMTEXT,
        name VARCHAR(255) not null,
        professor VARCHAR(255) not null,
        specialization VARCHAR(255),
        status BIT not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject_selection (
       id BINARY(16) not null,
        points smallint not null,
        subject_id binary(255) not null,
        registration_id BINARY(16),
        primary key (id)
    ) engine=InnoDB

    alter table hsa_subject_selection 
       add constraint FK5oo9djxl14bhig2rgv3th171x 
       foreign key (registration_id) 
       references hsa_registration (id)

    create table hsa_registration (
       id BINARY(16) not null,
        semester tinyint default 1,
        student varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_registration_window (
       id varchar(36) not null,
        end_date varchar(255) not null,
        semester varchar(255) not null,
        start_date varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject (
       id BINARY(16) not null,
        capacity SMALLINT not null,
        cp DECIMAL(3,1) not null,
        description MEDIUMTEXT,
        name VARCHAR(255) not null,
        professor VARCHAR(255) not null,
        specialization VARCHAR(255),
        status BIT not null,
        primary key (id)
    ) engine=InnoDB

    create table hsa_subject_selection (
       id BINARY(16) not null,
        points smallint not null,
        subject_id binary(255) not null,
        registration_id BINARY(16),
        primary key (id)
    ) engine=InnoDB

    alter table hsa_subject_selection 
       add constraint FK5oo9djxl14bhig2rgv3th171x 
       foreign key (registration_id) 
       references hsa_registration (id)
