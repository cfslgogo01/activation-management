create table User_login_detection
(
    userlogin_num    int auto_increment
        primary key,
    user_num         int          null,
    ainfo_num        int          null,
    userlogin_result varchar(255) null,
    userlogin_date   datetime     null,
    userlog_num      int          null
);

