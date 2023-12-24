create definer = root@`%` view 查看普通管理员日志 as
select `activation-management`.`admin_logs`.`adminlog_num`    AS `adminlog_num`,
       `activation-management`.`admin_logs`.`adminlog_type`   AS `adminlog_type`,
       `activation-management`.`admin_logs`.`admin_num`       AS `admin_num`,
       `activation-management`.`admin_logs`.`adminlog_result` AS `adminlog_result`,
       `activation-management`.`admin_logs`.`adminlog_date`   AS `adminlog_date`
from `activation-management`.`admin_logs`
where (`activation-management`.`admin_logs`.`admin_num` in
       (select `activation-management`.`root`.`root_num` from `activation-management`.`root`) is false);

