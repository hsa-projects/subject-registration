/*
 * WPF MySQL Creation Script - wpf.sql.
 */
-- Database-Level
DROP DATABASE IF EXISTS wpf -- Delete if exists
CREATE DATABASE wpf -- Create new database
USE wpf --  Set the default (current) database
-- Table-Level
create table HSA_SUBJECT
(
    ID             BINARY(16)   not null
        primary key,
    CP             FLOAT        not null,
    DESCRIPTION    VARCHAR(255),
    NAME           VARCHAR(255) not null,
    PROFESSOR      VARCHAR(255) not null,
    SPECIALIZATION VARCHAR(255)
);