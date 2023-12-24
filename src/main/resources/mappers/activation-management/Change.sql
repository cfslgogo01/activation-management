create table `Change`
(
    change_num int auto_increment
        primary key,
    c_type_num int          null,
    old_value  varchar(255) null,
    new_value  varchar(255) null,
    ainfo_num  int          null
);

