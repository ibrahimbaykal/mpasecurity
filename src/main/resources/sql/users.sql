create table musteri_portal.mpa_user
(
    id         bigserial not null
        constraint mpa_user_pkey
            primary key,
    activated  boolean   not null,
    email      varchar(254)
        constraint uk_nds9lkc7ppb71q4felb9ksktg
            unique,
    first_name varchar(50),
    last_name  varchar(50),
    password   varchar(255),
    user_name  varchar(50)
);

alter table musteri_portal.mpa_user
    owner to postgres;

