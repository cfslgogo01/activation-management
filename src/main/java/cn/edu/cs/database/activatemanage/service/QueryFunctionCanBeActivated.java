package cn.edu.cs.database.activatemanage.service;

import cn.edu.cs.database.activatemanage.dao.server.QueryFunctionCanBeActivatedDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 查询可以激活的功能
 */
@Service
public class QueryFunctionCanBeActivated {
    @Autowired
    QueryFunctionCanBeActivatedDAO queryFunctionCanBeActivatedDAO;

    public List<Map> getFunctionCanBeActivatedByuser_numAndcode_num(@Param("user_num") int user_num, @Param("activation_code") String activation_code) {
        return queryFunctionCanBeActivatedDAO.getFunctionCanBeActivatedByuser_numAndcode_num(user_num, activation_code);
    }
}
