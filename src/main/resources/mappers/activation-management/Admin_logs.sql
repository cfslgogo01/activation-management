create table Admin_logs
(
    adminlog_num    int auto_increment
        primary key,
    adminlog_type   varchar(255) not null,
    admin_num       int          not null,
    adminlog_result varchar(255) null,
    adminlog_date   datetime     null
);

