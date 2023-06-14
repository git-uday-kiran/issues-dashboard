-- auto-generated definition
create table GITHUB_PROJECT
(
    ID        INT auto_increment primary key,
    ORG_NAME  CHARACTER VARYING(50) not null,
    REPO_NAME CHARACTER VARYING(50) not null unique
);

create index IDX_REPO_NAME
    on GITHUB_PROJECT (ORG_NAME);
