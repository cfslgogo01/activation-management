package cn.edu.cs.database.activatemanage.service;

import cn.edu.cs.database.activatemanage.dao.server.QueryUserAcivationDAO;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Root/Admin 查询用户激活情况
 */
@Service
public class QueryUserAcivation {
    @Autowired
    QueryUserAcivationDAO queryUserAcivationDAO;


    @MapKey("activation_num")
    public List<Map> getUserAcivationByuser_num(int user_num) {
        return queryUserAcivationDAO.getUserAcivationByuser_num(user_num);
    }

    @MapKey("activation_num")
    public List<Map> getUserAcivationByuser_numAndfunc_num(int user_num, int func_num) {
        return queryUserAcivationDAO.getUserAcivationByuser_numAndfunc_num(user_num, func_num);
    }
}
