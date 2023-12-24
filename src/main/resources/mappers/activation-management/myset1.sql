create definer = root@`%` trigger myset1
    before insert
    on Activate_info
    for each row
BEGIN
     SET NEW.expiration_time_num = NEW.start_time_num + NEW.valid_time_num;
    IF NEW.expiration_time_num < UNIX_TIMESTAMP() THEN
        SET NEW.expiration_time_num = UNIX_TIMESTAMP() + NEW.valid_time_num;
    END IF;
    SET NEW.start_time = FROM_UNIXTIME(NEW.start_time_num, '%Y-%m-%d %H:%i:%s');
		 SET NEW.expiration_time = FROM_UNIXTIME(NEW.expiration_time_num, '%Y-%m-%d %H:%i:%s');
END;

