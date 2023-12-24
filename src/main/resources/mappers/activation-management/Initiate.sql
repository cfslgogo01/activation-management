create table Initiate
(
    initiate_num  int auto_increment
        primary key,
    admin_num_one int not null,
    admin_num_two int null,
    change_num    int not null,
    adminlog_num  int not null
);

