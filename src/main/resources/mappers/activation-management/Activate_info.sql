create table Activate_info
(
    ainfo_num           int auto_increment
        primary key,
    code_num            int          null,
    activation_code     varchar(255) null,
    start_time_num      bigint(32)   null,
    start_time          datetime     null,
    valid_time_num      bigint(32)   null,
    expiration_time_num bigint(32)   null,
    expiration_time     datetime     null,
    is_work             varchar(255) null
);

