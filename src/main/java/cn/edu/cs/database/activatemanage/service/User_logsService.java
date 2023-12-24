package cn.edu.cs.database.activatemanage.service;

import cn.edu.cs.database.activatemanage.dao.User_logsMapper;
import cn.edu.cs.database.activatemanage.entity.User_logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User_logsService {
    @Autowired
    User_logsMapper user_logsMapper;

    public int getCount() {
        return user_logsMapper.getCount();
    }

    public List<User_logs> getAll() {
        return user_logsMapper.getAll();
    }

    public List<User_logs> getUser_logsByuser_num(int user_num) {
        return user_logsMapper.getUser_logsByuser_num(user_num);
    }

    public int insert(User_logs user_logs) {
        return user_logsMapper.insert(user_logs);
    }
}
