--changeset mlakutina:20220509-01 failOnError:true
--preconditions onFail:MARK_RAN onError:HALT
--precondition-sql-check expectedResult:0 select count(*) from information_schema.tables where table_schema = 'core' and table_name = 'explorer';
create table IF NOT EXISTS core.explorer
(
    id    uuid       not null
        constraint explorer_pkey
            primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    gender varchar(255) not null,
    image_url varchar(255)

);
alter table core.explorer
    owner to postgres;
comment on table core.explorer is 'Explorer';