--changeset mlakutina:20220509-01 failOnError:true
--preconditions onFail:MARK_RAN onError:HALT
--precondition-sql-check expectedResult:0 select count(*) from information_schema.tables where table_schema = 'core' and table_name = 'spot';
create table IF NOT EXISTS core.spot
(
    id    uuid       not null
        constraint spot_pkey
            primary key,
    description varchar(255) not null,
    parent_id uuid
);

alter table core.spot
    owner to postgres;
comment on table core.spot is 'Spot';