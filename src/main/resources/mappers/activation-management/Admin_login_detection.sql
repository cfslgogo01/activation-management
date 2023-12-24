create table Admin_login_detection
(
    adminlogin_num    int          not null
        primary key,
    admin_num         int          not null,
    adminlogin_result varchar(255) null,
    adminlogin_date   datetime     null,
    adminlog_num      int          not null
);

