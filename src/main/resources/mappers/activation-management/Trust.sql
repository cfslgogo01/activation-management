create table Trust
(
    trust_num    int auto_increment
        primary key,
    root_num     int not null,
    admin_num    int not null,
    adminlog_num int not null
);

