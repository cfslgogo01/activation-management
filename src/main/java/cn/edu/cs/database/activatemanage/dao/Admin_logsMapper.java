package cn.edu.cs.database.activatemanage.dao;


import cn.edu.cs.database.activatemanage.entity.Admin_logs;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Admin_logs的Mapper类
 * 现在需要提供insert方法
 * 还需要select方法！
 */
@Repository
public interface Admin_logsMapper {
    int getCount();

    int insert(Admin_logs admin_logs);

    //查询所有的管理员日志
    List<Admin_logs> getAll();

    //查询普通管理员的日志！
    List<Admin_logs> getConAdminLogs();
}
