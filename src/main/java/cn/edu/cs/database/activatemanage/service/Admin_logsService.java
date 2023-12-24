package cn.edu.cs.database.activatemanage.service;

import cn.edu.cs.database.activatemanage.dao.Admin_logsMapper;
import cn.edu.cs.database.activatemanage.entity.Admin_logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Admin_logsService {
    @Autowired
    Admin_logsMapper admin_logsMapper;
    public int getCount() {
        return admin_logsMapper.getCount();
    }
    public int insert(Admin_logs admin_logs) {
        return admin_logsMapper.insert(admin_logs);
    }

    public List<Admin_logs> getAll() {
        return admin_logsMapper.getAll();
    }

    public List<Admin_logs> getConAdminLogs() {
        return admin_logsMapper.getConAdminLogs();
    }

}
