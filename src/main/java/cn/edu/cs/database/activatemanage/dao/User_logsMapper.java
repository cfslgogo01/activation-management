package cn.edu.cs.database.activatemanage.dao;


import cn.edu.cs.database.activatemanage.entity.User_logs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User_logsMapper {
    int getCount();
    List<User_logs> getAll();
    List<User_logs> getUser_logsByuser_num(@Param("user_num")int user_num);
//查询一条记录
    int insert(User_logs user_logs);
}
