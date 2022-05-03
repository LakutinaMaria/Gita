--changeset mlakutina:20220426-01 failOnError:true
--preconditions onFail:MARK_RAN onError:HALT
--precondition-sql-check expectedResult:0 select count(*) from information_schema.tables where table_schema = 'core' and table_name = 'adventure';
create table core.adventure
(
    id    uuid       not null
        constraint adventure_pkey
            primary key,
    dateTime        date  not null,
    finishDateTime  date,
    adventureStatus varchar(255) not null,
    spot            uuid not null

);
alter table core.adventure
    owner to postgres;
comment on table core.adventure is 'Adventure';
