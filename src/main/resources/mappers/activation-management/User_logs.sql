create table User_logs
(
    userlog_num    int auto_increment
        primary key,
    userlog_type   varchar(255) null,
    user_num       int          null,
    userlog_result varchar(255) null,
    userlog_date   datetime     null
);

