package cn.edu.cs.database.activatemanage.service;

import cn.edu.cs.database.activatemanage.dao.server.QueryActivationCodeStatusDAO;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 查询激活码状态信息
 * 查询激活码使用情况
 */
@Service
public class QueryActivationCodeStatus {



    @MapKey("ainfo_num")
    public List<Map> getActivationCodeStatusByactivation_code(String activation_code) {
        return queryActivationCodeStatusDAO.getActivationCodeStatusByactivation_code(activation_code);
    }

    @MapKey("ainfo_num")
    public List<Map> getActivationCodeStatusByuser_num(int user_num) {
        return queryActivationCodeStatusDAO.getActivationCodeStatusByuser_num(user_num);
    }

    @Autowired
    QueryActivationCodeStatusDAO queryActivationCodeStatusDAO;

    public List<Map> getActivatedActivationCodeStatusByuser_numAndactivation_code(int user_num, String activation_code) {
        return queryActivationCodeStatusDAO.getActivatedActivationCodeStatusByuser_numAndactivation_code(user_num, activation_code);
    }

}
