create table Conadmin
(
    admin_num int auto_increment
        primary key,
    admin_pwd varchar(32) not null,
    root_num  int         not null
);

