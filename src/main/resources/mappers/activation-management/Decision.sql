create table Decision
(
    decision_num int auto_increment
        primary key,
    root_num     int not null,
    change_num   int not null,
    adminlog_num int not null
);

